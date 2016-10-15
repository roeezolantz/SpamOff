import android.database.Cursor;
import android.database.CursorJoiner;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lior on 15-Oct-16.
 */
public class SMSReader {

    public ArrayList<String[]> read(Date date){
        ArrayList<String[]> united = new ArrayList<>();
        Cursor phoneSMSCursor = readFromPhone(date);
        Cursor simSMSCursor = readFromSim(date);
        String[] phoneTemplate = new String[] { "_id", "thread_id", "address", "person", "date", "body" };
        String[] simTemplate = new String[] { "_id", "thread_id", "address", "person", "date", "body" };

        CursorJoiner joiner = new CursorJoiner(phoneSMSCursor, phoneTemplate, simSMSCursor, simTemplate);
        for (CursorJoiner.Result result : joiner) {
            switch (result) {
                case RIGHT:

                 //   united.add(songCursor.getString(songCursor.getColumnIndexOrThrow(AudioColumn._ID)));
                    break;
                case LEFT:
                 //   leftSelectionArgsList.add(customSongCursor.getString(customSongCursor.getColumnIndexOrThrow(AudioColumn._ID)));
                    break;
            }
        }
        return united;
    }
    private Cursor readFromSim(Date date){
        if(isDualSim()){
            //TODO:
        }
        return null;
    }
    private Cursor readFromPhone(Date date){
        return null;
    }
    private boolean isDualSim(){
        return false;
    }

}
