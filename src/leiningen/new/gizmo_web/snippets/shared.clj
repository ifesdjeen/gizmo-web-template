(ns {{name}}.snippets.shared
  (:require [net.cgrand.enlive-html :as html]))

(html/defsnippet header-snippet "templates/shared/header.html"
  [:#content :*]
  [env])
