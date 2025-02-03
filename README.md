## TASK 1

Given a text file `file.txt`, that contains a list of telephone numbers (one row - one number).
Need to write a method that would read a file and print all the valid phone numbers to console.
A phone number is considered valid if it matches one of two formats:
- (xxx) xxx-xxxx
- xxx-xxx-xxxx

**Example**:
For file `file.txt` contains:
```
987-123-4567
123 456 7890
(123) 456-7890
```
method must print to console:
```
987-123-4567
(123) 456-7890
```

## TASK 2

There is a text file `file.txt`. Need to read file, convert it to a list of objects of type `User`, 
and write them in new file `user.json`.

File format:
- first row - title, contains object structure
- every next row - object, each column is separated by a space

**Example**:

For file `file.txt` contains:
```
name age
alice 21
ryan 30
```
must create next file `user.json`:
```
[
    {
        "name": "alice",
        "age":21
    },
    {
        "name": "ryan",
        "age":30
    }
]
```

## TASK 3
Write the method that will count the frequency of each word in a file `words.txt`.

Consider that:
- `words.txt` contains words in lowercase separated by a space
- Each word contains only letters in lowercase
- Words separated by one or more spaces or a line break

**Example**:

For file `words.txt` contains:
```
the day is sunny the the
the sunny is is
```
The method should return a result like:
```
the 4
is 3
sunny 2
day 1
```
**Attention**: Results must be sorted by frequency descending  виводу в консоль повинен бути відсортований за частотою 
(the most frequently occurring words come first)