package com.projectindigo.case_study_android_apps;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Nicolas on 3/06/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final  String DATABASE_NAME = "bmcdata.db";

    //Common Columns
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_FNAME = "FNAME";
    private static final String COLUMN_LNAME = "LNAME";

    //Visitor Table
    private static final String TABLE_VISITORS = "VISITORS";
    private static final String COLUMN_COMPANY = "COMPANY";
    private static final String COLUMN_REGO = "REGO";
    private static final String COLUMN_DATECREATED = "JOINDATE";
    private static final String COLUMN_EMAIL = "EMAIL";
    private static final String COLUMN_ADDRESS = "ADDRESS";

    //Visits Table
    private static final String TABLE_VISITS = "VISITS";
    private static final String COLUMN_VISITOR_ID = "VISITOR_ID";
    private static final String COLUMN_TIMEIN = "TIMEIN";
    private static final String COLUMN_TIMEOUT = "TIMEOUT";
    private static final String COLUMN_SIGNATURE = "SIGNATURE";
    private static final String COLUMN_INFO = "INFO";

    //Staff Table
    private static final String TABLE_STAFF = "STAFF";
    private static final String COLUMN_TITLE = "TITLE";
    private static final String COLUMN_DEPARTMENT = "DEPARTMENT";
    private static final String COLUMN_PHONE = "PHONE";

    //Appointment Table
    private static final String TABLE_APPOINTMENTS = "APPOINTMENTS";
    private static final String COLUMN_STAFF_ID = "STAFF_ID";
    private static final String COLUMN_DATETIME = "DATETIME";


    public DBHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Visitor Table
        String createVisitor =
                "CREATE TABLE " + TABLE_VISITORS + "(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_FNAME + " TEXT, " +
                        COLUMN_LNAME + " TEXT, " +
                        COLUMN_EMAIL + " TEXT, " +
                        COLUMN_PHONE + " TEXT, " +
                        COLUMN_ADDRESS + " TEXT, " +
                        COLUMN_COMPANY + " TEXT, " +
                        COLUMN_REGO + " TEXT, " +
                        COLUMN_DATECREATED + " TEXT " +
                        ");";
        db.execSQL(createVisitor);


        //Visits Table
        String createVisit =
                " CREATE TABLE " + TABLE_VISITS + "(" +
                        COLUMN_VISITOR_ID + " INTEGER, " +
                        COLUMN_TIMEIN + " TEXT, " +
                        COLUMN_TIMEOUT + " TEXT, " +
                        COLUMN_SIGNATURE + " TEXT, " +
                        COLUMN_INFO + " TEXT, " +
                        "FOREIGN KEY (" + COLUMN_VISITOR_ID + ") REFERENCES " + TABLE_VISITORS + "(" + COLUMN_ID + ") " +
                        "PRIMARY KEY("+COLUMN_VISITOR_ID+","+COLUMN_TIMEIN+")"+
                        ");";
        db.execSQL(createVisit);


        //Staff Table
        String createStaff =
                " CREATE TABLE " + TABLE_STAFF + "(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_FNAME + " TEXT, " +
                        COLUMN_LNAME + " TEXT, " +
                        COLUMN_TITLE + " TEXT, " +
                        COLUMN_DEPARTMENT + " TEXT, " +
                        COLUMN_PHONE + " TEXT "+
                        ");";
        db.execSQL(createStaff);


        //Staff Table
        String createAppointment =
                " CREATE TABLE " + TABLE_APPOINTMENTS + "(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_STAFF_ID + " INTEGER, " +
                        COLUMN_VISITOR_ID + " INTEGER, " +
                        COLUMN_DATETIME + " TEXT, " +
                        COLUMN_SIGNATURE + " TEXT, " +
                        "FOREIGN KEY (" + COLUMN_VISITOR_ID + ") REFERENCES " + TABLE_VISITORS + "(" + COLUMN_ID + "), " +
                        "FOREIGN KEY (" + COLUMN_STAFF_ID + ") REFERENCES " + TABLE_STAFF + "(" + COLUMN_ID + ") " +
                        ");";
        db.execSQL(createAppointment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_APPOINTMENTS +"; ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITS +"; ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VISITORS +"; ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STAFF + "; ");
        onCreate(db);
    }

    public Cursor GetAllVisitors(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_VISITORS + ";";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor GetAllVisits(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_VISITS + ";";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor GetAllAppointments(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_APPOINTMENTS + ";";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor GetAllStaff(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STAFF + ";";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor GetVisitorByID(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_VISITORS + " WHERE " + COLUMN_ID + "=\"" + id + "\"";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor GetVisitByVisitorID(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_VISITS + " WHERE " + COLUMN_VISITOR_ID + "=\"" + id + "\"";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor GetStaffByID(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_STAFF + " WHERE " + COLUMN_ID + "=\"" + id + "\"";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public Cursor GetAppointmentByID(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_APPOINTMENTS + " WHERE " + COLUMN_ID + "=\"" + id + "\"";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void newVisitor(Visitor newVisitor){
        SQLiteDatabase db = this.getWritableDatabase();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        String query =
                String.format("INSERT INTO %s(%s,%s,%s,%s,%s)",TABLE_VISITORS,COLUMN_FNAME,COLUMN_LNAME,COLUMN_EMAIL,COLUMN_PHONE,COLUMN_ADDRESS,COLUMN_COMPANY,COLUMN_REGO,COLUMN_DATECREATED)+
                String.format("VALUES(%s,%s,%s,%s,%s)",newVisitor.firstName,newVisitor.lastName, newVisitor.email, newVisitor.phone, newVisitor.address ,newVisitor.company, newVisitor.rego, dateFormat.format(cal.getTime()));
    }


}
