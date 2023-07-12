class Hotel:
    def __init__(self, name, location, rating, rooms_available):
        self.name = name
        self.location = location
        self.rating = rating
        self.rooms_available = rooms_available

    def display_info(self):
        print("Hotel Name:", self.name)
        print("Location:", self.location)
        print("Rating:", self.rating)
        print("Rooms Available:", self.rooms_available)

    def book_room(self, num_rooms):
        if num_rooms <= self.rooms_available:
            self.rooms_available -= num_rooms
            print("Successfully booked", num_rooms, "room(s).")
        else:
            print("Sorry, no enough rooms available.")

# Contoh penggunaan class Hotel
hotel = Hotel("Grand Hotel", "City Center", 4.5, 100)
hotel.display_info()  # Menampilkan informasi hotel
hotel.book_room(3)    # Mencoba memesan 3 kamar
hotel.display_info()  # Menampilkan informasi hotel setelah memesan kamar