(ns org.soulspace.clj.java.beaninfo
  (:use [org.soulspace.clj.java type-conversion])
  (:import [java.beans Introspector]))

(defn property-descriptor
  "Returns the property descriptor for the property with the given name."
  [inst prop-name]
  (first (filter
           #(= prop-name (.getName %)) 
           (.getPropertyDescriptors (Introspector/getBeanInfo (class inst))))))

(defn get-property-class
  "Returns the class of a property by the given property write method."
  [write-method]
  (first (.getParameterTypes write-method)))

(defn set-property!
  "Sets the property on the given instance to value."
  [inst prop value]
  (let [pd (property-descriptor inst prop)]
    (if (nil? pd) (throw (IllegalArgumentException. (str "No such property " prop))))
    (let [write-method (.getWriteMethod pd)
          dest-class (get-property-class write-method)]
      (.invoke write-method inst (into-array [(coerce dest-class value)])))))

(defn set-properties!
  "Sets the properties given in the map to the instance."
  [inst prop-map]
  (doseq [[k v] prop-map] (set-property! inst (name k) v))) 
