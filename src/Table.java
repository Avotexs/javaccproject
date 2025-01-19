import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private List<Column> columns;
    private List<String> constraints;
    private List<String> foreignKeys;
    private List<String> indexes;

    // Constructeur
    public Table(String name) {
        this.name = name;
        this.columns = new ArrayList<>();
        this.constraints = new ArrayList<>();
        this.foreignKeys = new ArrayList<>();
        this.indexes = new ArrayList<>();
    }

    // Ajouter une colonne
    public void addColumn(Column column) {
        columns.add(column);
    }

    // Ajouter une contrainte
    public void addConstraint(String constraint) {
        constraints.add(constraint);
    }

    // Ajouter une clé étrangère
    public void addForeignKey(String foreignKey) {
        foreignKeys.add(foreignKey);
    }

    // Ajouter un index
    public void addIndex(String index) {
        indexes.add(index);
    }

    // Générer le script SQL pour créer la table
    public String generateCreateTableSQL() {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ").append(name).append(" (\n");

        // Ajouter les colonnes
        for (Column column : columns) {
            sb.append("\t").append(column.getName()).append(" ").append(column.getType());
            if (column.isNotNull()) {
                sb.append(" NOT NULL");
            }
            if (column.getDefaultValue() != null) {
                sb.append(" DEFAULT ").append(column.getDefaultValue());
            }
            sb.append(",\n");
        }

        // Ajouter les contraintes
        for (String constraint : constraints) {
            sb.append("\t").append(constraint).append(",\n");
        }

        // Ajouter les clés étrangères
        for (String foreignKey : foreignKeys) {
            sb.append("\t").append(foreignKey).append(",\n");
        }

        // Supprimer la dernière virgule
        if (sb.charAt(sb.length() - 2) == ',') {
            sb.delete(sb.length() - 2, sb.length());
        }

        sb.append("\n);\n");

        // Ajouter les index
        for (String index : indexes) {
            sb.append(index).append(";\n");
        }

        return sb.toString();
    }
}
