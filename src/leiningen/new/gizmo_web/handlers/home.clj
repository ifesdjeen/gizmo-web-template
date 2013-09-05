(ns {{name}}.handlers.home)

(defn index
  [request]
  {:render :html
   :widgets {:main-content '{{name}}.widgets.home/index-content}})
