package pfc.Jclic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseSQLite extends SQLiteOpenHelper {


	private static final String DATABASE_NAME = "BDClic.db";
	public final String TITULO = "titulo";
	public final String DESCRIPCION = "descripcion";
	public final String RANGO_EDAD = "rango_edad";
	public final String AUTOR = "autor";
	public final String IDIOMA = "idioma";
	public final String CATEGORIA = "categoria";
	public final String ICONO = "icono";
	public final String KEYWORDS = "keywords";
	public final String JCLIC = "jclic";
	
    private static final String sqlCreate = "CREATE TABLE Clics (_id integer primary key autoincrement, " +
    		"titulo TEXT unique not null, descripcion TEXT, rango_edad TEXT, autor TEXT, idioma TEXT, categoria TEXT, " +
    		"icono varchar(1000), keywords varchar (1000), jclic varchar(1000))";
 
 
 
    public DataBaseSQLite (Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, DATABASE_NAME, null, 3);
    }
 
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
		android.util.Log.w("Clics", "Upgrading database, which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS Clics");
        //db.execSQL(sqlCreate);
        onCreate(db);
    }
    
}