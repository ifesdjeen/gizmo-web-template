(ns leiningen.new.gizmo-web
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "gizmo-web"))

(defn gizmo-web
  "FIXME: write documentation"
  [name]
  (let [data {:name name
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
             ["resources/public/javascripts/application.js" (render "resources/public/javascripts/application.js" data)])))
