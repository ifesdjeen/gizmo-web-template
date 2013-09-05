(ns {{name}}.widgets.home
    (:require [clojurewerkz.gizmo.widget :refer [defwidget]]
              [{{name}}.snippets.home :as snippets]))

(defwidget index-content
  :view snippets/index-snippet
  :fetch (fn [_]))
