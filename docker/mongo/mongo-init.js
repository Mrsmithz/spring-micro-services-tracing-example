db = new Mongo().getDB("test");
db.createCollection('book_rating', { capped: false });

db.book_rating.insert([
    {   "bookId": 1,
        "rating":3.5,
        "reviews":"reviews 1"
    },
    {
        "bookId": 2,
        "rating":3.5,
        "reviews":"reviews 2"
    },
]);