# Bookshop 

Here you can see the BookShop project. This is a demo project

## Admin panel

Admin panel http://localhost:8085/admin/genadmin

The Admin menu item will appear at login admin@admin.ru the password is admin. The rights are not yet delimited, just a menu item is shown and hidden. Completion of the admin panel is already possible for the customer and specific needs, wishlist.

### Add a book:

Fill in the data, select the image file and the book file. You don't have to choose them, they won't swear.
In the settings, you need to specify a folder and specify the path (highlighted in yellow) where subfolders for storing images and files will be created.

```
upload.path=C:/Users/kochuev.dmitry/OneDrive/Development/Skillbox/resources/codewizard/book-covers
download.path=C:/Users/kochuev.dmitry/OneDrive/Development/Skillbox/resources/codewizard/book-files
authorsPhoto.path=C:/Users/kochuev.dmitry/OneDrive/Development/Skillbox/resources/codewizard/authors-photos
```

### Edit Books:
Select the book to edit from the drop-down list and click apply, the book data will be loaded.
Changing the data. Where the default image is selected not to change, you can not change. If we want to change an image or a file, then in each option we need to select from the drop-down list.
Click save.

### Edit authors:
By analogy with books. Select the author from the list, apply. Editing.

### Moderation of new reviews:
If there are reviews, they will appear in the list for moderation. They can be added to any book if you are logged in. I.e. the review first goes to moderation before being displayed.
Either confirm or delete the incorrect review.

### User moderation:
Select the user, click apply. Changing the data. Passwords are encrypted as expected. You can ban it, but so far it is just a user property and has not been applied anywhere.

### Moderation of the user's bookshelves:
Here we select the user, apply. You can select any book and add it, it will appear in the shopping list (you can implement all kinds of notifications to the user and gift labels). You can also delete books from the user's shelves.

