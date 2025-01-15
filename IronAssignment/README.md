## Solution

I used a HashMap with key as keystrokes in mobile and our resultant expected character as value. To get the resultant output string I traversed the input string and maintained start and end as two pointers for processing keystrokes for single char. When we reach at blankspace or # or when current char is not same as previous char, we have our substring keystroke to process. This was the approach I followed, Thanks !!

