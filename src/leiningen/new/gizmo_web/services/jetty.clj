(ns {{name}}.services.jetty
  ^{:doc "Jetty service"}
  (:use [clojurewerkz.gizmo.service])
  (:require [ring.adapter.jetty :as jetty]
            [clojurewerkz.gizmo.config :as config]
            [{{name}}.core :as app-core]))

(defservice jetty-service
  :config #(:jetty config/settings)
  :alive (fn [service]
           (println service)

           )
  :stop (fn [service])
  :start (fn [service]
           (reset-state service
                        (jetty/run-jetty #'app-core/dev-app-handler (config service)))))
