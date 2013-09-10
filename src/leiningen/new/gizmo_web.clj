(ns leiningen.new.gizmo-web
  (:require [clojure.java.io :as io]
            [leiningen.new.templates :refer [renderer name-to-path ->files *dir*]]))

(def render (renderer "gizmo-web"))

(defn gizmo-web
  "FIXME: write documentation"
  [name & more]
  (let [options (set more)
        data    {:name name
                 :sanitized (name-to-path name)}]
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["config/development.clj" (render "config/development.clj" data)]

             ["src/{{sanitized}}/cli_entrypoint.clj" (render "cli_entrypoint.clj" data)]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/{{sanitized}}/routes.clj" (render "routes.clj" data)]

             ["src/{{sanitized}}/services/jetty.clj" (render "services/jetty.clj" data)]
             ["src/{{sanitized}}/services/nrepl.clj" (render "services/nrepl.clj" data)]

             ["src/{{sanitized}}/snippets/layouts.clj" (render "snippets/layouts.clj" data)]

             ["src/{{sanitized}}/handlers/home.clj" (render "handlers/home.clj" data)]

             ["src/{{sanitized}}/snippets/home.clj" (render "snippets/home.clj" data)]
             ["src/{{sanitized}}/widgets/home.clj" (render "widgets/home.clj" data)]

             ["src/{{sanitized}}/snippets/shared.clj" (render "snippets/shared.clj" data)]
             ["src/{{sanitized}}/widgets/shared.clj" (render "widgets/shared.clj" data)]

             ["resources/templates/layouts/application.html" (render "resources/templates/layouts/application.html" data)]
             ["resources/templates/home/index.html" (render "resources/templates/home/index.html" data)]
             ["resources/templates/shared/header.html" (render "resources/templates/shared/header.html" data)]

             ["resources/public/stylesheets/application.css" (render "resources/public/stylesheets/application.css" data)]
             ["resources/public/javascripts/application.js" (render "resources/public/javascripts/application.js" data)])

    (when (get options "--bootstrap")
      (binding [*dir* (-> (System/getProperty "leiningen.original.pwd")
                          (io/file name) (.getPath))]
        (->files data
                 ["resources/templates/layouts/application.html" (render "resources_bootstrap/templates/layouts/application.html" data)]
                 ["resources/templates/home/index.html" (render "resources_bootstrap/templates/home/index.html" data)]
                 ["resources/templates/shared/header.html" (render "resources_bootstrap/templates/shared/header.html" data)]

                 ["resources/public/stylesheets/application.css" (render "resources/public/stylesheets/application.css" data)]
                 ["resources/public/javascripts/application.js" (render "resources/public/javascripts/application.js" data)]

                 ["resources/public/fonts/glyphicons-halflings-regular.eot"
                  (render "resources_bootstrap/public/fonts/glyphicons-halflings-regular.eot" data)]
                 ["resources/public/fonts/glyphicons-halflings-regular.svg"
                  (render "resources_bootstrap/public/fonts/glyphicons-halflings-regular.svg" data)]
                 ["resources/public/fonts/glyphicons-halflings-regular.ttf"
                  (render "resources_bootstrap/public/fonts/glyphicons-halflings-regular.ttf" data)]
                 ["resources/public/fonts/glyphicons-halflings-regular.woff"
                  (render "resources_bootstrap/public/fonts/glyphicons-halflings-regular.woff" data)]

                 ["resources/public/javascripts/vendor/bootstrap.min.js"
                  (render "resources_bootstrap/public/javascripts/vendor/bootstrap.min.js" data)]
                 ["resources/public/javascripts/vendor/jquery-2.0.3.min.js"
                  (render "resources_bootstrap/public/javascripts/vendor/jquery-2.0.3.min.js" data)]

                 ["resources/public/stylesheets/vendor/bootstrap-theme.min.css"
                  (render "resources_bootstrap/public/stylesheets/vendor/bootstrap-theme.min.css" data)]
                 ["resources/public/stylesheets/vendor/bootstrap.min.css"
                  (render "resources_bootstrap/public/stylesheets/vendor/bootstrap.min.css" data)]

                 )))))
