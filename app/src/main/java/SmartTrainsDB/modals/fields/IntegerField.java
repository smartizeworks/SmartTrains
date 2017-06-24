package SmartTrainsDB.modals.fields;

import android.database.Cursor;

/**
 *  class to represent interger type column in db
 */

public class IntegerField extends Field {
    private static final String sqlTypeName = "INT";

    public IntegerField(boolean isPrimaryKey) {
        super(isPrimaryKey);
    }

    public IntegerField() {
        super(false);
    }


    @Override
    public String getSqlTypeName() {
        return sqlTypeName;
    }

    @Override
    public String getDefinition() {
        return isPrimaryKey() ? super.getDefinition() + " AUTO INCREMENT" : super.getDefinition();
    }

    @Override
    public boolean validate(Object object) {
        if (object instanceof Integer) {
            return true;
        }
        try {
            Integer.parseInt(object.toString());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Object getValue(Cursor cursor) {
        return cursor.getInt(cursor.getColumnIndex(getName()));
    }
}
