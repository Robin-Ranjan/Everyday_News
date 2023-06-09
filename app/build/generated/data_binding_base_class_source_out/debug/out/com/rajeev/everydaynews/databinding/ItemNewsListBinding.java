// Generated by view binder compiler. Do not edit!
package com.rajeev.everydaynews.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.rajeev.everydaynews.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemNewsListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Barrier barrier2;

  @NonNull
  public final CardView cardView;

  @NonNull
  public final TextView listAuthorName;

  @NonNull
  public final ConstraintLayout listConstrain;

  @NonNull
  public final ImageView listImg;

  @NonNull
  public final TextView listTime;

  @NonNull
  public final TextView listTitle;

  private ItemNewsListBinding(@NonNull ConstraintLayout rootView, @NonNull Barrier barrier2,
      @NonNull CardView cardView, @NonNull TextView listAuthorName,
      @NonNull ConstraintLayout listConstrain, @NonNull ImageView listImg,
      @NonNull TextView listTime, @NonNull TextView listTitle) {
    this.rootView = rootView;
    this.barrier2 = barrier2;
    this.cardView = cardView;
    this.listAuthorName = listAuthorName;
    this.listConstrain = listConstrain;
    this.listImg = listImg;
    this.listTime = listTime;
    this.listTitle = listTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemNewsListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemNewsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_news_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemNewsListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.barrier2;
      Barrier barrier2 = ViewBindings.findChildViewById(rootView, id);
      if (barrier2 == null) {
        break missingId;
      }

      id = R.id.cardView;
      CardView cardView = ViewBindings.findChildViewById(rootView, id);
      if (cardView == null) {
        break missingId;
      }

      id = R.id.listAuthorName;
      TextView listAuthorName = ViewBindings.findChildViewById(rootView, id);
      if (listAuthorName == null) {
        break missingId;
      }

      ConstraintLayout listConstrain = (ConstraintLayout) rootView;

      id = R.id.listImg;
      ImageView listImg = ViewBindings.findChildViewById(rootView, id);
      if (listImg == null) {
        break missingId;
      }

      id = R.id.listTime;
      TextView listTime = ViewBindings.findChildViewById(rootView, id);
      if (listTime == null) {
        break missingId;
      }

      id = R.id.listTitle;
      TextView listTitle = ViewBindings.findChildViewById(rootView, id);
      if (listTitle == null) {
        break missingId;
      }

      return new ItemNewsListBinding((ConstraintLayout) rootView, barrier2, cardView,
          listAuthorName, listConstrain, listImg, listTime, listTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
