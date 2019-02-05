(ns msg-chat.core
	(:require [ring.adapter.jetty      :as jetty]
            [ring.middleware.reload  :refer [wrap-reload]]
            [compojure.core          :refer [defroutes GET]]
            [compojure.route         :refer [not-found resources]]
            [ring.handler.dump       :refer [handle-dump]]
            [hiccup.core             :refer :all]
            [hiccup.page             :refer :all]
  )
)

(defn welcome
  [request]
    (html5 {:lang "en"}
      [:head (include-css "mystyle.css") (include-css "https://fonts.googleapis.com/css?family=Open+Sans:300,400,700")
        [:meta {:charset "utf-8"}]
        [:meta {:http-equiv "x-ua-compatible" :content "ie=edge"}]
        [:title "Chat Boilerplate"]
        [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, shrink-to-fit=no"}]       
      ]
      [:body 
        [:div#header]
        [:div#container
          [:div#contacts.pane
            [:div.title
              [:div.profile_img {:style "background-image:url('images/img1.jpg')"}]
              [:div#chat_icon {:style "background-image:url('images/msg.png')"}]
              [:div.options_icon {:style "background-image:url('images/menu.png')"}]
            ]
            [:div.search
              [:input {:type "text" :placeholder "Search Contacts"}]
            ]
            [:div.contact
              [:div.img {:style "background-image:url('images/img2.jpg')"}]
              [:div.name "Baishakhi"
                [:div.last_msg "Baishakhi: Stop spelling my name wrong! its not so hard"]
                [:div.time "10:40"]
              ]
            ]
            [:div.contact
              [:div.img {:style "background-image:url('images/img1.jpg')"}]
              [:div.name "Vikram"
                [:div.last_msg "Vikram: what's the difference between class and Id"]
                [:div.time "8:40"]
              ]
            ]
          ]
          [:div#messages.pane
            [:div.title
              [:div.profile_img {:style "background-image:url('images/img3.jpg')"}]
              [:div#chat_title "Vikram"]
              [:div#last_seen "Last seen today at 8:30 am"]
              [:div#attach {:style "background-image:url('images/attach.png')"}]
              [:div.options_icon {:style "background-image:url('images/menu.png')"}]
            ]
            [:div.messages 
              [:div.last_msg "My name is Vikram"
                [:div.time "7:30"]
              ]
            ]
            [:div.messages.mine
              [:div.last_msg "My name is Vikram"
                [:div.time "7:30"]
              ]
            ]
            [:div#footer_bar
              [:div#smiley]
              [:input {:type "text" :placeholder "Search Messages"}]
              [:div#mike]
            ]
          ]
        ]
      ]
    )
)

(defroutes app
  (GET "/" [] welcome)
  (resources "/")
)

(defn -main
    "A simple layout for the msg-chat page"
    [port-number]
    (jetty/run-jetty app
        {:port (Integer. port-number)}
    )
)

(defn -dev-main
  "A simple page layout for the msg-chat"
  [port-number]
  (jetty/run-jetty (wrap-reload #'app)
      {:port (Integer. port-number)}
  )
)