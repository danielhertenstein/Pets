package com.example.android.pets;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.pets.data.PetContract.PetEntry;

public class PetCursorAdapter extends CursorAdapter {
    public PetCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nameView = (TextView) view.findViewById(R.id.name);
        TextView breedView = (TextView) view.findViewById(R.id.summary);

        String nameString = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_NAME));
        String breedString = cursor.getString(cursor.getColumnIndex(PetEntry.COLUMN_PET_BREED));

        nameView.setText(nameString);
        breedView.setText(breedString);
    }
}
