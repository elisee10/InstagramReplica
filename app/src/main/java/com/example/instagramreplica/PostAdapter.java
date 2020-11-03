

package com.example.instagramreplica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

//Created a java class called Posts Adapter and extended RecyclerView.Adapter
//Then we created a view holder in the class which we referenced in the main class  <PostsAdapter.ViewHolder>
//Option enter postsadapter to implement the needed methods
//Identify the context and model and create constructors for it (using command N, shift and select)
//Inflate the layout  view in the onCreateViewHolder method
// Return size of the model in getItemCount
// Write code to get the position of the posts
// Create the

public class PostAdapter extends RecyclerView.Adapter <PostAdapter.ViewHolder>{

    private final Context context;
    private final List<Post> posts;

/*    public PostAdapter(Context context, List<Post> allPosts) {

  }*/

    public PostAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tvUsername;
        private final ImageView ivImage;
        private final TextView tvDescription;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivImage = itemView.findViewById(R.id.ivImage);

        }

        public void bind(Post post) {
            //Bind the post data to the view elements
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            ParseFile image = post.getImage();
            if (image != null){
                Glide.with(context).load(post.getImage().getUrl()).into(ivImage);
            }
        }
    }

}
