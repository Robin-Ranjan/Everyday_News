// Generated by view binder compiler. Do not edit!
package com.rajeev.everydaynews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.rajeev.everydaynews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityArticleBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextView aTitle;

  @NonNull
  public final TextView articleDate;

  @NonNull
  public final TextView articleView;

  @NonNull
  public final ImageView authorImg;

  @NonNull
  public final CardView cardView2;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final TextView listAuthorName;

  @NonNull
  public final ImageView postImage;

  @NonNull
  public final MaterialButton tweetButton;

  private ActivityArticleBinding(@NonNull ScrollView rootView, @NonNull TextView aTitle,
      @NonNull TextView articleDate, @NonNull TextView articleView, @NonNull ImageView authorImg,
      @NonNull CardView cardView2, @NonNull ImageView imageView4, @NonNull TextView listAuthorName,
      @NonNull ImageView postImage, @NonNull MaterialButton tweetButton) {
    this.rootView = rootView;
    this.aTitle = aTitle;
    this.articleDate = articleDate;
    this.articleView = articleView;
    this.authorImg = authorImg;
    this.cardView2 = cardView2;
    this.imageView4 = imageView4;
    this.listAuthorName = listAuthorName;
    this.postImage = postImage;
    this.tweetButton = tweetButton;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityArticleBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityArticleBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_article, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityArticleBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.aTitle;
      TextView aTitle = ViewBindings.findChildViewById(rootView, id);
      if (aTitle == null) {
        break missingId;
      }

      id = R.id.articleDate;
      TextView articleDate = ViewBindings.findChildViewById(rootView, id);
      if (articleDate == null) {
        break missingId;
      }

      id = R.id.articleView;
      TextView articleView = ViewBindings.findChildViewById(rootView, id);
      if (articleView == null) {
        break missingId;
      }

      id = R.id.authorImg;
      ImageView authorImg = ViewBindings.findChildViewById(rootView, id);
      if (authorImg == null) {
        break missingId;
      }

      id = R.id.cardView2;
      CardView cardView2 = ViewBindings.findChildViewById(rootView, id);
      if (cardView2 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = ViewBindings.findChildViewById(rootView, id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.listAuthorName;
      TextView listAuthorName = ViewBindings.findChildViewById(rootView, id);
      if (listAuthorName == null) {
        break missingId;
      }

      id = R.id.postImage;
      ImageView postImage = ViewBindings.findChildViewById(rootView, id);
      if (postImage == null) {
        break missingId;
      }

      id = R.id.tweetButton;
      MaterialButton tweetButton = ViewBindings.findChildViewById(rootView, id);
      if (tweetButton == null) {
        break missingId;
      }

      return new ActivityArticleBinding((ScrollView) rootView, aTitle, articleDate, articleView,
          authorImg, cardView2, imageView4, listAuthorName, postImage, tweetButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
