;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.system)

(defn get-environment-variable
  "Returns the environment variable named var.
   If a default is specified and the environment variable is not set, the default will be returned."
  ([var]
    (System/getenv (name var)))
  ([var default]
    (let [env (get-environment-variable var)]
      (if (seq? env)
        env
        default))))

(defn set-system-property
  "Sets a system property."
  [property value]
  (System/setProperty property value))

(defn get-system-property
  "Gets a system property.
   If a default is specified and the property is not set, the default will be returned."
  ([property]
    (System/getProperty property))
  ([property default]
    (System/getProperty property default)))

(defn clear-system-property
  "Removes the system propery."
  [property]
  (System/clearProperty property))

(defn nano-time
  "Returns the current time in nano seconds."
  []
  (System/nanoTime))

(defn milli-time
  "Returns the current time in milli seconds."
  []
  (System/currentTimeMillis))

(defn line-separator
  "Returns the line separator of the current system."
  []
  (System/lineSeparator))

(defn exit
  "Terminates the currently running JVM."
  [status]
  (System/exit status))
