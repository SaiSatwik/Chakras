package com.example.mockexam;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class Chakras extends AppCompatActivity {

    private ChakraViewModel mChakraViewModel;
    private RecyclerView recyclerView;
    private ChakraAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chakras);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mChakraViewModel = ViewModelProviders.of(this).get(ChakraViewModel.class);
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ChakraAdapter(this,mChakraViewModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        mChakraViewModel.getAllChakras().observe(this, new Observer<List<ChakraEntity>>() {
            @Override
            public void onChanged(@Nullable final List<ChakraEntity> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setChakras(words);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.load) {
            ChakraEntity ce1=new ChakraEntity("Sahasrara","Highest spiritual centre, pure consciousness, containing neither object nor subject. When the feminine Kundalini Shakti rises to this point, it unites with the masculine Shiva, giving self-realization and samadhi.[68] In esoteric Buddhism, it is called Mahasukha, the petal lotus of \"Great Bliss\" corresponding to the fourth state of Four Noble Truths.",false);
            ChakraEntity ce2=new ChakraEntity("Ajna","Guru chakra or third-eye chakra, the subtle center of energy, where the tantra guru touches the seeker during the initiation ritual (saktipata). He or she commands the awakened kundalini to pass through this centre.",false);
            ChakraEntity ce3=new ChakraEntity("Vishuddha","The Vishuddha is iconographically represented with 16 petals covered with the sixteen Sanskrit vowels. It is associated with the element of space (akasha) and has the seed syllable of the space element Ham at its centre. The residing deity is Panchavaktra shiva, with 5 heads and 4 arms, and the Shakti is Shakini.[4]\n" +
                    "\n" +
                    "In esoteric Buddhism, it is called Sambhoga and is generally considered to be the petal lotus of \"Enjoyment\" corresponding to the third state of Four Noble Truths.",false);
            ChakraEntity ce4=new ChakraEntity("Anahata","Within it is a yantra of two intersecting triangles, forming a hexagram, symbolising a union of the male and female as well as being the esoteric symbol for the element of air (vayu). The seed mantra of air, Yam, is at its centre. The presiding deity is Ishana Rudra Shiva, and the Shakti is Kakini.[70]\n" +
                    "\n" +
                    "In esoteric Buddhism, this Chakra is called Dharma and is generally considered to be the petal lotus of \"Essential nature\" and corresponding to the second state of Four Noble Truths.",false);
            ChakraEntity ce5=new ChakraEntity("Manipura","For the Nath yogi meditation system, this is described as the Madhyama-Shakti or the intermediate stage of self-discovery.[66] This chakra is represented as an upward pointing triangle representing fire in the middle of a lotus with ten petals. The seed syllable for fire is at its center Ram. The presiding deity is Braddha Rudra, with Lakini as the Shakti.",false);
            ChakraEntity ce6=new ChakraEntity("Svadhishthana","Svadhisthana is represented with a lotus within which is a crescent moon symbolizing the water element. The seed mantra in its center is Vam representing water. The presiding deity is Brahma, with the Shakti being Rakini (or Chakini).[4]\n" +
                    "\n" +
                    "In esoteric Buddhism, it is called Nirmana, the petal lotus of \"Creation\" and corresponding to the first state of Four Noble Truths.",false);
            ChakraEntity ce7=new ChakraEntity("Muladhara","Dormant Kundalini is often said to be resting here, wrapped three and a half, or seven or twelve times. Sometimes she is wrapped around the black Svayambhu linga, the lowest of three obstructions to her full rising (also known as knots or granthis).[71] It is symbolised as a four-petaled lotus with a yellow square at its center representing the element of earth.[4]\n" +
                    "\n" +
                    "The seed syllable is Lam for the earth element (pronounced lum),. All sounds, words and mantras in their dormant form rest in the muladhara chakra, where Ganesha resides,[72] while the Shakti is Dakini.[73] The associated animal is the elephant.",false);
            mChakraViewModel.insert(ce1);
            mChakraViewModel.insert(ce2);
            mChakraViewModel.insert(ce3);
            mChakraViewModel.insert(ce4);
            mChakraViewModel.insert(ce5);
            mChakraViewModel.insert(ce6);
            mChakraViewModel.insert(ce7);
            return true;
        }

        if(id==R.id.delete){
            mChakraViewModel.deleteAll();
        }

        return super.onOptionsItemSelected(item);
    }

}
