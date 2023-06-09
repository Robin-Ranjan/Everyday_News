// Generated by view binder compiler. Do not edit!
package com.rajeev.everydaynews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import com.rajeev.everydaynews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemNewsCardBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final MaterialCardView articleCard;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TextView mArticleExcerpt;

  @NonNull
  public final TextView mArticleTitleCard;

  private ItemNewsCardBinding(@NonNull ConstraintLayout rootView,
      @NonNull MaterialCardView articleCard, @NonNull ImageView imageView2,
      @NonNull TextView mArticleExcerpt, @NonNull TextView mArticleTitleCard) {
    this.rootView = rootView;
    this.articleCard = articleCard;
    this.imageView2 = imageView2;
    this.mArticleExcerpt = mArticleExcerpt;
    this.mArticleTitleCard = mArticleTitleCard;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemNewsCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemNewsCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_news_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemNewsCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.articleCard;
      MaterialCardView articleCard = ViewBindings.findChildViewById(rootView, id);
      if (articleCard == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = ViewBindings.findChildViewById(rootView, id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.mArticleExcerpt;
      TextView mArticleExcerpt = ViewBindings.findChildViewById(rootView, id);
      if (mArticleExcerpt == null) {
        break missingId;
      }

      id = R.id.mArticleTitleCard;
      TextView mArticleTitleCard = ViewBindings.findChildViewById(rootView, id);
      if (mArticleTitleCard == null) {
        break missingId;
      }

      return new ItemNewsCardBinding((ConstraintLayout) rootView, articleCard, imageView2,
          mArticleExcerpt, mArticleTitleCard);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
