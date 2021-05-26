# Flexi Test Scrambler

## Installation
lein install

### descriptions
Scramblies challenge
Task 1
Complete the function (scramble str1 str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false

Notes:
Only lower case letters will be used (a-z). No punctuation or digits will be included.
Performance needs to be considered

Examples:
(scramble? “rekqodlw” ”world”) ==> true
(scramble? “cedewaraaossoqqyt” ”codewars”) ==> true
(scramble? “katas”  “steak”) ==> false

Task 2
Create a web service that accepts two strings in a request and applies function scramble? from previous task to them.

### Task 3 is done in another repo:
Create a UI in ClojureScript with two inputs for strings and a scramble button. When the button is fired it should call the API from previous task and display a result.
- frontend app in clojure-script is available at [FrontEnd](https://github.com/cinguilherme/flexi-fontend-cljs)

Notes
Please pay attention to tests, code readability and error cases.



## Usage

FIXME: explanation

    $ java -jar playground2-0.1.0-standalone.jar [args]

## License
MIT