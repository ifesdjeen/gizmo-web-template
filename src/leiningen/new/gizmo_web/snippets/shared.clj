(ns {{name}}.snippets.shared
  (:require [net.cgrand.enlive-html :as html]
            [clojurewerkz.gizmo.enlive :refer [defsnippet within]]))

(html/defsnippet header-snippet "templates/shared/header.html"
  [*header]
  [env])
