# Console Application

$ myprogram LANGUAGE WORD

This program needs to print into the console whether the word exists in the dictionary of the given language.
In case the word exists, it needs to print the definitions of the word.
In case the word does not exist, it needs to print a list of the most similar words in the dictionary

## Example

$ myprogram english helo

The word "helo" does not exist in the dictionary. Did you mean:
- hello
- help
- hell
- ...
dictionaries are going to be files... named as the language... and with the extension .txt 
In those files we will have a list of words... one per line... followed by a list of definitions... in the same line... separated each other by |.

# English dictionary

apple=Fruit of the apple tree
banana=Fruit of the banana tree

#In case a word has more than 1 definition:
free=Not under the control or in the power of another|able to act or be done as one wishes.

In my spanish dictionary file I have more than 600.000 words... < 100 ms 

In order to look for words similar to the given one, we will need to compute the levenstein distance between the given word and all the words in the dictionary.

## levenstein distance

Given 2 words... it calculates the number of chars that need to be:
- changed
- inserted
- deleted
to go from one word to the other. 

## Example

helo - hello -> 1 (to insert the l)
halos - hello -> 3 (to update the a->e, insert an l and to delete the s)