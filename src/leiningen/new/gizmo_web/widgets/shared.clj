(ns {{name}}.widgets.shared
  (:require [clojurewerkz.gizmo.widget :refer [defwidget]]
            [{{name}}.snippets.shared :as shared]))

(defwidget header
  :view shared/header-snippet
  :fetch (fn [_]))
