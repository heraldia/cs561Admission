package dao;


import java.util.List;

import exception.DAOException;
import model.Note;


public class NoteDAO extends HibernateDAO{

	/**
	 * save note
	 * @param note : an note object
	 * @return void
	 */
	public void saveNote(Note note)
	{
		if (note == null)
			return;

		saveObject(note);
	}


//	public Note getNote(String Note)
//	{
//		Note u = (Note) getObject("from Note u where u.admit = '" + Note
//				+ "'");
//		return u;
//	}
/*
	public Note getNoteByNoteId(Long NoteId)
	{
		Note u = (Note) getObject("from Note u where u.id = '" + NoteId
				+ "'");
		return u;
	}
*/

	
	/**
	 * get note by object id
	 * @return an Note
	 */
	public Note getNoteById(Long id)
	{
		return (Note) getObject(Note.class, id);
	}

	
    /**
     * this method will update Note info
     * @param Note the Note entity
     */
    public void updateNote(Note Note) {
        updateObject(Note);
    }
    
	
	/**
	 * return all notes
	 * @return success
	 */
	public List getNoteByList()
	{
		return super.getObjects("from Note");
	}
	
}
