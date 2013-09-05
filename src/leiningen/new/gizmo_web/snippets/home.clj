(ns {{name}}.snippets.home
  (:require [net.cgrand.enlive-html :as html]))

(html/defsnippet index-snippet "templates/home/index.html"
  [:#content]
  [env])
