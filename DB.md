# Database structure

## book

- id INT NOT NULL AUTO_INCREMENT
- pub_date DATE NOT NULL — publication date
- is_bestseller TINYINT NOT NULL — the book is very popular, is a bestseller
- slug VARCHAR(255) NOT NULL — mnemonic identifier of the book
- title VARCHAR(255) NOT NULL — title of the book
- image VARCHAR(255) — cover image
- description TEXT — description of the book
- price INT NOT NULL — the main price in rubles
- discount TINYINT NOT NULL DEFAULT 0 — discount as a percentage or 0 if there is none

## author — authors of books

- id INT NOT NULL AUTO_INCREMENT
- photo VARCHAR(255) — image with the author's photo
- slug VARCHAR(255) NOT NULL — mnemonic identifier of the author, which will be displayed in the link to his page
- name VARCHAR(255) NOT NULL — first and last name of the author
- description TEXT — description (biography, characteristic)

## book2author — linking authors to books

- id INT NOT NULL AUTO_INCREMENT
- book_id INT NOT NULL — book ID
- author_id INT NOT NULL — author ID
- sort_index INT NOT NULL DEFAULT 0 — author's ordinal number

## book_review — book reviews

- id INT NOT NULL AUTO_INCREMENT
- book_id INT NOT NULL — book ID
- user_id INT NOT NULL — ID of the user who wrote this review
- time DATETIME NOT NULL — the time when the review was left
- text TEXT NOT NULL — review text

## book_review_like — likes and dislikes of reviews

- id INT NOT NULL AUTO_INCREMENT
- review_id INT NOT NULL — review ID
- user_id INT NOT NULL — ID of the user who put a like or dislike
- time DATETIME NOT NULL — the date and time at which the like or dislike is set
- value TINYINT NOT NULL — like (1) or dislike (-1)

## genre — genres (tree)

- id INT NOT NULL AUTO_INCREMENT
- parent_id INT — id of the parent genre or NULL if the genre is the root
- slug VARCHAR(255) NOT NULL — mnemonic genre code used in links to a page of this genre
- name VARCHAR(255) NOT NULL — genre name

## book2genre — linking books to genres

- id INT NOT NULL AUTO_INCREMENT
- book_id INT NOT NULL — book ID
- genre_id INT NOT NULL — genre identifier

## users — store user

- id INT NOT NULL AUTO_INCREMENT
- hash VARCHAR(255) NOT NULL — the hash of the user used for external identification of the user in order to hide his ID
- reg_time DATETIME NOT NULL — date and time of registration
- balance INT NOT NULL — personal account balance, default 0
- name VARCHAR(255) — user name

## user_contact — user's contact

- id INT NOT NULL AUTO_INCREMENT
- user_id INT NOT NULL — ID of the user to whom this contact belongs
- type ENUM(‘PHONE’, ‘EMAIL’) NOT NULL — contact type (phone or e-mail)
- approved TINYINT NOT NULL — whether the contact is confirmed (0 or 1)
- code VARCHAR(255) — confirmation code
- code_trials INT — the number of attempts to enter the confirmation code
- code_time DATETIME — date and time of the confirmation code generation
- contact VARCHAR(255) NOT NULL — contact (e-mail or phone)


## book2user — linking books to users

- id INT NOT NULL AUTO_INCREMENT
- time DATETIME NOT NULL — date and time of binding occurrence
- type_id INT NOT NULL — the type of binding of the book to the user
- book_id INT NOT NULL — book ID
- user_id INT NOT NULL — user ID

## book2user_type — types of bindings of books to users

- id INT NOT NULL AUTO_INCREMENT
- code VARCHAR(255) NOT NULL — binding type code (see the list below)
- name VARCHAR(255) NOT NULL — the name of the binding type (see the list below)
  - Postponed — KEPT
  - In the cart — CART
  - Purchased — PAID
  - In the archive — ARCHIVED

## balance_transaction — transactions on user accounts

- id INT NOT NULL AUTO_INCREMENT
- user_id INT NOT NULL — user ID
- time DATETIME NOT NULL — date and time of the transaction
- value INT NOT NULL DEFAULT 0 — transaction size (positive — crediting, negative — debiting)
- book_id INT NOT NULL — the book for which the purchase was debited, or NULL
- description TEXT NOT NULL — description of the transaction: if it is credited, then from where, if it is debited, then to what

## book_file — book files

- id INT NOT NULL AUTO_INCREMENT
- hash VARCHAR(255) NOT NULL — a random hash designed to identify the file when downloading.
- type_id INT NOT NULL — file type
- path VARCHAR(255) NOT NULL — file path

## book_file_type — types of book files

- id INT NOT NULL AUTO_INCREMENT
- name VARCHAR(255) NOT NULL
  - PDF
  - EPUB
  - FB2
- description TEXT — description of file types

## file_download — the number of downloads of the book by the user

- id INT NOT NULL AUTO_INCREMENT
- user_id INT NOT NULL — ID of the user who downloaded the book
- book_id INT NOT NULL — id of the downloaded book
- count INT NOT NULL DEFAULT 1 — number of downloads

## document — documents

- id INT NOT NULL AUTO_INCREMENT
- sort_index INT NOT NULL DEFAULT 0 — the ordinal number of the document (for output on the document list page)
- slug VARCHAR(255) NOT NULL — mnemonic document code displayed in the link to the document page
- title VARCHAR(255) NOT NULL — document name
- text TEXT NOT NULL — the text of the document in HTML format

## faq — frequently asked questions and answers

- id INT NOT NULL AUTO_INCREMENT
- sort_index INT NOT NULL DEFAULT 0 — the sequential number of the question in the list of questions on the Help page
- question VARCHAR(255) NOT NULL — question
- answer TEXT NOT NULL — response in HTML format

## message — messages to the feedback form

- id INT NOT NULL AUTO_INCREMENT
- time DATETIME NOT NULL — date and time of sending the message
- user_id INT — if the user was logged in
- email VARCHAR(255) — the user's email address if he was not authorized
- name VARCHAR(255) — the name of the user, if he was not authorized
- subject VARCHAR(255) NOT NULL — subject of the message
- text TEXT NOT NULL — message text