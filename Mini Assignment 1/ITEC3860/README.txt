The data file is structured in the following format:
Room number
Room description
Has it been visited
(Item) create new txt file
(Puzzle) create new txt file
The room in the north direction
The room in the east direction
The room in the south direction
The room in the west direction

The map & compass look like this:
---------
| 1 ¦ 2 |         N
-- --- --         ^
| 3 ¦ 4 |     W <-|-> E
-- --- --         v
| 5 ¦ 6 |         S
---------
If you're in room 1, you can only go east into room 2 & south into room 3.
If you're in room 2, you can only go south into room 4 & west into room 1.
If you're in room 3, you can only go north into room 1, east into room 4, 
& south into room 5.
If you're in room 4, you can only go north into room 2, south into room 6,
& west into room 3.
If you're in room 5, you can only go north into room 3 & east into room 6.
If you're in room 6, you can only go north into room 4 & west into room 5.