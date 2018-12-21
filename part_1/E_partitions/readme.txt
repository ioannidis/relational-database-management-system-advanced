Η σειρά με την οποία οι εντολές πρέπει να εκτελεστούν είναι η εξής:

1. Ανοίγουμε τα αρχεία accidents_tables.sql και vehicles_tables.sql
   και εκτελούμε τις εντολές ώστε να δημιουργηθούν τα partitions.

2. Ανοίγουμε τα αρχεία accidents_indexes.sql και vehicles_indexes.sql
   και εκτελούμε τις εντολές ώστε να δημιουργηθούν τα indexes για κάθε
   partition table που φτιάξαμε προηγουμένως.

3. Ανοίγουμε τα αρχεία accidents_triggers.sql και vehicles_triggers.sql
   ώστε να δημιουργήσουμε τα functions που θα εκτελεί κάθε trigger. Τρέχουμε
   τις εντολές που περιέχονται ώστε κάθε φορά που εισάγουμε ένα νέο στοιχείο
   στους δυο πίνακες θα καταχωρείται και στο αντίστοιχο partition table.

https://www.postgresql.org/docs/11/ddl-partitioning.html
