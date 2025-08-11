(ns webproject.data.data)

(defrecord Profile [name age image description hobbies id])

(defn all-profiles []
  {:1 (Profile. "Kharn the Betrayer" 10000 "/images/kharn.webp" "A very angry man." "Likes chopping heads" 1)
   :2 (Profile. "Abadonn the Despoiler" 10001 "/images/abadon.webp" "A very insecure man" "Like to overlord, but mostly fails." 2)
   :3 (Profile. "Robute Gulliman" 10100 "/images/nerd.jpg" "A very good boy" "Will organize your empire for you." 3)})

(defn get-profile
  "Gets a single profile using a keyword"
  [id]
  (id (all-profiles)))



