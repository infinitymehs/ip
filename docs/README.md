# MeowthCLI User Guide
```
         .-. \\_/ .-.
         \.-/\\/=-/.-/
      '-./___|=|___\.-'
     .--| \|/`"`\|/ |--.
    (((_)\  .---.  /(_)))
     `\ \_`-.   .-'_/ /`_
       '.__       __.'(_))
           /     \     //
          |       |.'__/
          \       /--'`
      .--,-' .--. '----.
     '----`--'  '--`----'
```

> **MeowthCLI** is a Team Rocket-themed command line task management application built in Java.  
> Manage your todos, deadlines, and events with Meowth's intuitive commands!<br>
> Tasklist is automatically saved upon exit and imported upon entering! 

## Quick Start
1. **Run** `java -jar meowth.jar` to start
2. **Type** your commands (e.g., `todo Buy groceries`)
3. **See** instant feedback after each command
4. **Type** `bye` to exit and autos-save

**Task indices are 1-based** (first task is `1`, second is `2`, etc.)

## Listing tasks
If you want to view the entire tasklist, use the `list` command! 
**Format**: `list`

Example: 
```
----------------------------------------
list
1. [T][ ] task 1
2. [D][ ] task 2 (by: saturday)
3. [E][ ] task 3 (from: 1200 to: 1300)
----------------------------------------
```

## Adding Todos
If you want to add a todo into the tasklist, use the `todo` command!

**Format**: `todo <desc>`

Example: 
```
----------------------------------------
todo [CS2113] iP
Added: [CS2113] iP
Now you have 1 tasks in the list!
---------------------------------------
list
1. [T][ ] [CS2113] iP
----------------------------------------
```

## Adding deadlines
If you want to add a deadline into the tasklist, use the `deadline` command!

**Format**: `deadline <desc> /by <date>`

Example: 
```
----------------------------------------
deadline [CS2113] iP /by Friday 2359
Added: [CS2113] iP
Now you have 1 tasks in the list!
----------------------------------------
list
1. [D][ ] [CS2113] iP (by: Friday 2359)
----------------------------------------
```

## Adding events
If you want to add an event into the tasklist, use the `event` command!

**Format**: `event <desc> /from <start> /to <end>`

Example: 
```
----------------------------------------
event Study Session with friends /from 14/3 1200 /to 1700
Added: Study Session with friends
Now you have 1 tasks in the list!
----------------------------------------
list
1. [E][ ] Study Session with friends (from: 14/3 1200 to: 1700)
----------------------------------------
```

## Marking tasks
To mark tasks in the tasklist as done, use the `mark` command!

**Format**: `mark <index>`

Example: 
```
----------------------------------------
list
1. [T][ ] [CS2113] iP
----------------------------------------
mark 1
This task is marked as done! Out of the way!
[X] [CS2113] iP
----------------------------------------
list
1. [T][X] [CS2113] iP
----------------------------------------
```

## Unmarking tasks
To unmark tasks in the tasklist as done, use the `unmark` command!

**Format**: `unmark <index>`

Example: 
```
----------------------------------------
list
1. [T][X] [CS2113] iP
----------------------------------------
unmark 1
This task is marked as undone :(
[ ] [CS2113] iP
----------------------------------------
list
1. [T][ ] [CS2113] iP
----------------------------------------
```

## Deleting tasks
To delete tasks from the tasklist, use the `delete` command!

**Format**: `delete <index>`

Example: 
```
----------------------------------------
list
1. [T][ ] [CS2113] iP
----------------------------------------
delete 1
Got it! Deleted the task meow~
Now you have 0 tasks in the list
----------------------------------------
list
List is empty, have you taken over the world?
----------------------------------------
```

## Finding tasks
To find tasks with a specific keyword, use the `find` command!

**Format**: `find <keyword>`

Example: 
```
----------------------------------------
list
1. [T][ ] todo 1
2. [D][ ] deadline 1 (by: saturday)
3. [E][ ] event 1 (from: 1200 to: 1300)
4. [T][ ] todo 2
5. [D][ ] deadline 2 (by: saturday)
6. [E][ ] event 2 (from: 1200 to: 1300)
----------------------------------------
find todo
1. [T][ ] todo 1
2. [T][ ] todo 2
----------------------------------------
```

## Exiting CLI
If you want to exit the CLI, just use the `bye` command!

**Format**: `bye`

Example: 
```
----------------------------------------
bye
Team Rocket's blasting off againnnnnnn!
----------------------------------------
```

## Command Summary

| Command | Format | Example |
|---------|--------|---------|
| Todo | `todo <desc>` | `todo homework` |
| Deadline | `deadline <desc> /by <time>` | `deadline iP /by Dec 1` |
| Event | `event <desc> /from <s> /to <e>` | `event meeting /from 2pm /to 3pm` |
| List | `list` | `list` |
| Mark | `mark <index>` | `mark 1` |
| Unmark | `unmark <index>` | `unmark 1` |
| Delete | `delete <index>` | `delete 1` |
| Find | `find <keyword>` | `find project` |
| Exit | `bye` | `bye` |

**Pro tip**: Use `list` first to see task numbers before `mark`/`delete`/`unmark`!

---
*Prepare for trouble! And make it double!*
