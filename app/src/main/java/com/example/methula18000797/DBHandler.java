package com.example.methula18000797;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHandler extends  SQLiteOpenHelper {

    //constatnt varibale - database name
    private static final String DB_NAME = "mydatabase.db";

    //database version
    private static final int DB_VERSION = 1;
    protected Context context;

    //table name
    private static final String TABLE_NAME = "students";

    //columns
    private static final String FNAME = "FNAME";
    private static final String LNAME = "LNAME";
    private static final String DOB = "DOB";
    private static final String GENDER = "GENDER";
    private static final String PA = "PA";
    private static final String EMAIL = "EMAIL";
    private static final String CONT = "CONT";
    private static final String NOK = "NOK";
    private static final String CNOK = "CNOK";
    private static final String FAC = "FAC";
    private static final String PROG = "PROG";
    private static final String SEMAIL = "SEMAIL";
    private static final String ID = "ID";





    public DBHandler(MainActivityREG context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public DBHandler(MainActivitySR context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" + FNAME + "TEXT, "+ LNAME + "TEXT, "+ DOB + "TEXT, " + GENDER + "TEXT, "+
                PA + "TEXT, " + EMAIL + "TEXT, " + CONT + "TEXT, " + NOK + "TEXT, " + CNOK + "TEXT, "
                + FAC + "TEXT, " + PROG + "TEXT, " + SEMAIL + "TEXT, "+ ID + "TEXT)";
        db.execSQL(query);
    }

    //function to add values
    public void add(String f, String l, String d, String g, String p, String e, String c, String n,
                    String cn, String fa, String pr, String em, String id)
    {
        //getting writable database
        SQLiteDatabase db = this.getWritableDatabase();
        //creating varriable for content
        ContentValues values = new ContentValues();

        //passing values intot
        values.put(FNAME, f);
        values.put(LNAME, l);
        values.put(DOB, d);
        values.put(GENDER, g);
        values.put(PA, p);
        values.put(EMAIL, e);
        values.put(CONT, c);
        values.put(NOK, n);
        values.put(CNOK, cn);
        values.put(FAC, fa);
        values.put(SEMAIL, em);
        values.put(ID, id);

        //passing content
        db.insert(TABLE_NAME, null, values);
        //closing database
        db.close();

    }
    //get all students
    public String[] getAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        final Cursor c = db.rawQuery(" SELECT * FROM "+ TABLE_NAME, null);
        int count = c.getCount();

        if(count ==0)
        {
            Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
            c.close();
        }

        String[] result = {"","","","","","","","","","","",""};
        int f = c.getColumnIndex(FNAME);
        int l = c.getColumnIndex(LNAME);
        int d = c.getColumnIndex(DOB);
        int g = c.getColumnIndex(GENDER);
        int p = c.getColumnIndex(PA);
        int e = c.getColumnIndex(EMAIL);
        int co = c.getColumnIndex(CONT);
        int n = c.getColumnIndex(NOK);
        int cn = c.getColumnIndex(CNOK);
        int fa = c.getColumnIndex(FAC);
        int se = c.getColumnIndex(SEMAIL);
        int id = c.getColumnIndex(ID);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result[0] = c.getString(f);
            result[1] = c.getString(l);
            result[2] = c.getString(d);
            result[3] =c.getString(g);
            result[4] = c.getString(p);
            result[5] = c.getString(e);
            result[6] = c.getString(co);
            result[7] = c.getString(n);
            result[8] = c.getString(cn);
            result[9] = c.getString(fa);
            result[10] = c.getString(se);
            result[11] = c.getString(id);
        }
        return result;
    }

    //all details of a student
    public String[] getDetails(String ID)
    {

        SQLiteDatabase db = this.getReadableDatabase();

        final Cursor c = db.rawQuery("SELECT FNAME, LNAME, DOB, GENDER, PA, " +
                "EMAIL, CONT, NOK, CNOK, FAC, SEMAIL, ID FROM " + TABLE_NAME + " WHERE ID = '"+ ID + "'", null);
        int count = c.getCount();

        if(count ==0)
        {
            Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
            c.close();
        }

        String[] result = {"","","","","","","","","","","",""};
        int f = c.getColumnIndex(FNAME);
        int l = c.getColumnIndex(LNAME);
        int d = c.getColumnIndex(DOB);
        int g = c.getColumnIndex(GENDER);
        int p = c.getColumnIndex(PA);
        int e = c.getColumnIndex(EMAIL);
        int co = c.getColumnIndex(CONT);
        int n = c.getColumnIndex(NOK);
        int cn = c.getColumnIndex(CNOK);
        int fa = c.getColumnIndex(FAC);
        int se = c.getColumnIndex(SEMAIL);
        int id = c.getColumnIndex(ID);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result[0] = c.getString(f);
            result[1] = c.getString(l);
            result[2] = c.getString(d);
            result[3] =c.getString(g);
            result[4] = c.getString(p);
            result[5] = c.getString(e);
            result[6] = c.getString(co);
            result[7] = c.getString(n);
            result[8] = c.getString(cn);
            result[9] = c.getString(fa);
            result[10] = c.getString(se);
            result[11] = c.getString(id);
        }
        return result;
    }

    //get all male students
    public String[] getMales()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        final Cursor c = db.rawQuery("SELECT FNAME, LNAME, DOB, GENDER, PA, " +
                "EMAIL, CONT, NOK, CNOK, FAC, SEMAIL, ID FROM " + TABLE_NAME + " WHERE GENDER LIKE 'm%'", null);
        int count = c.getCount();

        if(count ==0)
        {
            Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
            c.close();
        }

        String[] result = {"","","","","","","","","","","",""};
        int f = c.getColumnIndex(FNAME);
        int l = c.getColumnIndex(LNAME);
        int d = c.getColumnIndex(DOB);
        int g = c.getColumnIndex(GENDER);
        int p = c.getColumnIndex(PA);
        int e = c.getColumnIndex(EMAIL);
        int co = c.getColumnIndex(CONT);
        int n = c.getColumnIndex(NOK);
        int cn = c.getColumnIndex(CNOK);
        int fa = c.getColumnIndex(FAC);
        int se = c.getColumnIndex(SEMAIL);
        int id = c.getColumnIndex(ID);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result[0] = c.getString(f);
            result[1] = c.getString(l);
            result[2] = c.getString(d);
            result[3] =c.getString(g);
            result[4] = c.getString(p);
            result[5] = c.getString(e);
            result[6] = c.getString(co);
            result[7] = c.getString(n);
            result[8] = c.getString(cn);
            result[9] = c.getString(fa);
            result[10] = c.getString(se);
            result[11] = c.getString(id);
        }
        return result;


    }

    //get all females
    public String[] getFemales()
    {
        SQLiteDatabase db = this.getReadableDatabase();

        final Cursor c = db.rawQuery("SELECT FNAME, LNAME, DOB, GENDER, PA, " +
                "EMAIL, CONT, NOK, CNOK, FAC, SEMAIL, ID FROM " + TABLE_NAME + " WHERE GENDER LIKE 'f%'", null);
        int count = c.getCount();

        if(count ==0)
        {
            Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
            c.close();
        }

        String[] result = {"","","","","","","","","","","",""};
        int f = c.getColumnIndex(FNAME);
        int l = c.getColumnIndex(LNAME);
        int d = c.getColumnIndex(DOB);
        int g = c.getColumnIndex(GENDER);
        int p = c.getColumnIndex(PA);
        int e = c.getColumnIndex(EMAIL);
        int co = c.getColumnIndex(CONT);
        int n = c.getColumnIndex(NOK);
        int cn = c.getColumnIndex(CNOK);
        int fa = c.getColumnIndex(FAC);
        int se = c.getColumnIndex(SEMAIL);
        int id = c.getColumnIndex(ID);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result[0] = c.getString(f);
            result[1] = c.getString(l);
            result[2] = c.getString(d);
            result[3] =c.getString(g);
            result[4] = c.getString(p);
            result[5] = c.getString(e);
            result[6] = c.getString(co);
            result[7] = c.getString(n);
            result[8] = c.getString(cn);
            result[9] = c.getString(fa);
            result[10] = c.getString(se);
            result[11] = c.getString(id);
        }
        return result;
    }

    //get students from certain faculty
    public String[] getFaculty(String fac)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        final Cursor c = db.rawQuery("SELECT FNAME, LNAME, DOB, GENDER, PA, " +
                "EMAIL, CONT, NOK, CNOK, FAC, SEMAIL, ID FROM " + TABLE_NAME + " WHERE FAC LIKE %'"+ fac+"%'", null);
        int count = c.getCount();

        if(count ==0)
        {
            Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
            c.close();
        }

        String[] result = {"","","","","","","","","","","",""};
        int f = c.getColumnIndex(FNAME);
        int l = c.getColumnIndex(LNAME);
        int d = c.getColumnIndex(DOB);
        int g = c.getColumnIndex(GENDER);
        int p = c.getColumnIndex(PA);
        int e = c.getColumnIndex(EMAIL);
        int co = c.getColumnIndex(CONT);
        int n = c.getColumnIndex(NOK);
        int cn = c.getColumnIndex(CNOK);
        int fa = c.getColumnIndex(FAC);
        int se = c.getColumnIndex(SEMAIL);
        int id = c.getColumnIndex(ID);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result[0] = c.getString(f);
            result[1] = c.getString(l);
            result[2] = c.getString(d);
            result[3] =c.getString(g);
            result[4] = c.getString(p);
            result[5] = c.getString(e);
            result[6] = c.getString(co);
            result[7] = c.getString(n);
            result[8] = c.getString(cn);
            result[9] = c.getString(fa);
            result[10] = c.getString(se);
            result[11] = c.getString(id);
        }
        return result;
    }

    //get students from particular programme
    public String[] getProg(String prog)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        final Cursor c = db.rawQuery("SELECT FNAME, LNAME, DOB, GENDER, PA, " +
                "EMAIL, CONT, NOK, CNOK, FAC, SEMAIL, ID FROM " + TABLE_NAME + " WHERE FAC LIKE %'"+ prog+"%'", null);
        int count = c.getCount();

        if(count ==0)
        {
            Toast.makeText(context, "Not Found", Toast.LENGTH_SHORT).show();
            c.close();
        }

        String[] result = {"","","","","","","","","","","",""};
        int f = c.getColumnIndex(FNAME);
        int l = c.getColumnIndex(LNAME);
        int d = c.getColumnIndex(DOB);
        int g = c.getColumnIndex(GENDER);
        int p = c.getColumnIndex(PA);
        int e = c.getColumnIndex(EMAIL);
        int co = c.getColumnIndex(CONT);
        int n = c.getColumnIndex(NOK);
        int cn = c.getColumnIndex(CNOK);
        int fa = c.getColumnIndex(FAC);
        int se = c.getColumnIndex(SEMAIL);
        int id = c.getColumnIndex(ID);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            result[0] = c.getString(f);
            result[1] = c.getString(l);
            result[2] = c.getString(d);
            result[3] =c.getString(g);
            result[4] = c.getString(p);
            result[5] = c.getString(e);
            result[6] = c.getString(co);
            result[7] = c.getString(n);
            result[8] = c.getString(cn);
            result[9] = c.getString(fa);
            result[10] = c.getString(se);
            result[11] = c.getString(id);
        }
        return result;
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
