Η σειρά με την οποία τα αρχεία πρέπει να εκτελεστούν είναι η εξής:

1. Εκτελούμε τον κώδικα στο αρχείο tables.sql για να δημιουργήσουμε
   τους απαραίτητους πίνακες που θα κάνουν το partitioning
   των accident_information και vehicle_information.

2. Εκτελούμε τον κώδικα στο αρχείο indexes.sql για να ορίσουμε τα indexes
   του κάθε partitioning table.

3. Εκτελούμε τον κώδικα στο αρχείο functions.sql για να δημιουργήσουμε τις
   διαδικασίες ανακατεύθυνσης δεδομένων κατά την εισαγωγή στα κατάλληλα
   partitioning tables.

4. Εκτελούμε τον κώδικα στο αρχείο triggers.sql για να ορίσουμε τους trigger
   που χρησιμοποιούν τα functions με την εισαγωγή νέων δεδομένων στη βάση.

https://www.postgresql.org/docs/11/ddl-partitioning.html
