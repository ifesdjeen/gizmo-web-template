(ns {{name}}.cli-entrypoint
  (:gen-class)
  (:require [clojure.tools.cli :refer [cli]]
            [compojure.handler :refer [api]]
            [clojurewerkz.gizmo
             [core :refer [require-widgets require-snippets require-handlers
                           require-services register-snippet-reload]]
             [config :refer [load-config!]]
             [service :refer [start-all! all-services]]]))

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
  (register-snippet-reload "{{name}}")

  (start-all!))
