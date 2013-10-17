(ns {{name}}.routes
    (:use [clojurewerkz.route-one.compojure]
          [{{name}}.handlers.home])
    (:require [compojure.core :as compojure]
              [compojure.route :as route]))

(compojure/defroutes main-routes
  (GET root "/" request ({{name}}.handlers.home/index request))
  (GET favicon "/favicon.ico" _ (fn [_] {:render :nothing}))
  (route/not-found "Page not found"))
