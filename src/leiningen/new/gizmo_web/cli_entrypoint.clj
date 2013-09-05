(ns {{name}}.cli-entrypoint
  (:gen-class)
  (:require [clojure.tools.cli :refer [cli]]
            [compojure.handler :refer [api]]
            [clojurewerkz.gizmo.core :refer [require-widgets require-snippets require-handlers require-services]]
            [clojurewerkz.gizmo.config :refer [load-config!]]
            [clojurewerkz.gizmo.service :refer [start-all! all-services]]))

(alter-var-root #'*out* (constantly *out*))

(defn -main
  [& args]
  (let [[options positional-args banner] (cli args
                                              ["--config" "Path to configuration file to use"])]
    (load-config! (:config options)))
  (require-snippets "{{name}}")
  (require-handlers "{{name}}")
  (require-widgets "{{name}}")
  (require-services "{{name}}")

  (println 'services (all-services))
  (start-all!)
  (while true
    (Thread/sleep 10)))
