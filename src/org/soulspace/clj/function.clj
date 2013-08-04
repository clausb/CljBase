;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.function
  (:require [clojure.string :as str]))

(defn not-nil? 
  "Tests if the argument is not nil. Same as (not (nil? x)) or ((complement nil?) x)."
  [x]
  (not (nil? x)))

; TODO remove (move to CljAppFramework)
(defn get-env
  "Returns the environment variable named var."
  ([var]
    (System/getenv (name var)))
  ([var default]
    (let [env (get-env var)]
      (if-not (nil? env)
        env
        default))))
