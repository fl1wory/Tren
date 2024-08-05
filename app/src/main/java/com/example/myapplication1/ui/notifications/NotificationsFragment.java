package com.example.myapplication1.ui.notifications;

import static android.content.Context.MODE_PRIVATE;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.myapplication1.R;
import com.example.myapplication1.databinding.FragmentNotificationsBinding;
import com.example.myapplication1.db.DbManager;

import java.util.ArrayList;
import java.util.List;
import com.example.myapplication1.db.*;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private DbManager dbManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        dbManager = new DbManager(container.getContext());

        List<Integer> proteins = dbManager.getFromDb(CostantasDB.PROTEIN);
        List<Integer> fats = dbManager.getFromDb(CostantasDB.FAT);
        List<Integer> carbohydrates = dbManager.getFromDb(CostantasDB.CARBOHYDRATES);
        LinearLayout tableLayout = binding.LinearLayout; // посилання на TableLayout, в якому знаходяться елементи TableRow
        TableRow originalRow = binding.prd0; // посилання на оригінальний елемент TableRow

        int rowCount = proteins.size(); // Отримати кількість рядків у базі даних

        for (int i = 0; i < rowCount; i++) {
            TableRow newRow = new TableRow(container.getContext()); // Створити новий елемент TableRow
            newRow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            ));
            // Скопіювати вміст оригінального елемента TableRow в новий елемент
            for (int j = 0; j < originalRow.getChildCount(); j++) {
                View originalChild = originalRow.getChildAt(j);
                View newChild = LayoutInflater.from(container.getContext()).inflate(
                        originalChild.getLayoutResource(),
                        newRow,
                        false
                );
                if (newChild instanceof TextView) {
                    ((TextView) newChild).setText(((TextView) originalChild).getText());
                }
                newRow.addView(newChild);
            }
            tableLayout.addView(newRow); // Додати новий елемент TableRow до TableLayout
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void addToDb() {
        dbManager.openDb();
        dbManager.insertToDb("name", 1, 2, 3);
        dbManager.closeDb();
    }
}