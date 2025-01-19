public class SQLGenerator {

    public static void main(String[] args) {

        Table users = new Table("users");


        users.addColumn(new Column("id", "INT", true, null));
        users.addColumn(new Column("name", "VARCHAR(255)", false, null));
        users.addColumn(new Column("email", "VARCHAR(255)", false, null));


        users.addConstraint("PRIMARY KEY (id)");
        users.addConstraint("UNIQUE (email)");


        users.addForeignKey("FOREIGN KEY (id) REFERENCES another_table(id)");


        users.addIndex("CREATE INDEX idx_name ON users (name)");


        String createUsersTableSQL = users.generateCreateTableSQL();
        System.out.println(createUsersTableSQL);


    }
}

