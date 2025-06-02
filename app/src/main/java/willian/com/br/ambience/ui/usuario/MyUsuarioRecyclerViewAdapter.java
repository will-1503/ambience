package willian.com.br.ambience.ui.usuario;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import willian.com.br.ambience.databinding.FragmentConUsuarioBinding;
import willian.com.br.ambience.model.Usuario;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Usuario}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyUsuarioRecyclerViewAdapter extends RecyclerView.Adapter<MyUsuarioRecyclerViewAdapter.ViewHolder> {

    private final List<Usuario> mValues;

    public MyUsuarioRecyclerViewAdapter(List<Usuario> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConUsuarioBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getNome());
        holder.mContentView.setText(mValues.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Usuario mItem;

        public ViewHolder(FragmentConUsuarioBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}