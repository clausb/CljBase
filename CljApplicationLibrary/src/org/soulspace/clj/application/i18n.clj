;
;   Copyright (c) Ludger Solbach. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file license.txt at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software.
;
(ns org.soulspace.clj.application.i18n)

(defn bundle
  "Returns the resource bundle of the name (default name is resources)."
  ([]
    (java.util.ResourceBundle/getBundle "resources"))
  ([bundle-name]
    (java.util.ResourceBundle/getBundle bundle-name)))

(defn bundle-lookup
  "Looks up the key in the resource bundle and returns the resulting string."
  ([bundle str-key]
    (.getString bundle str-key)))

; TODO
(defn switch-locale []
  )
