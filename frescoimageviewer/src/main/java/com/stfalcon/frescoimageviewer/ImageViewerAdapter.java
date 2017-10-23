package com.stfalcon.frescoimageviewer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stfalcon.frescoimageviewer.adapter.RecyclingPagerAdapter;
import com.stfalcon.frescoimageviewer.adapter.ViewHolder;


import java.util.HashSet;

/*
 * Created by troy379 on 07.12.16.
 */
class ImageViewerAdapter
        extends RecyclingPagerAdapter<ImageViewerAdapter.ImageViewHolder> {

    private Context context;
    private ImageViewer.DataSet<?> dataSet;
    private HashSet<ImageViewHolder> holders;
    private boolean isZoomingAllowed;

    ImageViewerAdapter(Context context, ImageViewer.DataSet<?> dataSet, boolean isZoomingAllowed) {
        this.context = context;
        this.dataSet = dataSet;
        this.holders = new HashSet<>();
        this.isZoomingAllowed = isZoomingAllowed;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ImageView drawee = new ImageView(context);
        drawee.setEnabled(isZoomingAllowed);

        ImageViewHolder holder = new ImageViewHolder(drawee);
        holders.add(holder);

        return holder;
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        holder.bind(context, position);
    }

    @Override
    public int getItemCount() {
        return dataSet.getData().size();
    }


    boolean isScaled(int index) {
        for (ImageViewHolder holder : holders) {
            if (holder.position == index) {
                return holder.isScaled;
            }
        }
        return false;
    }

    void resetScale(int index) {
        for (ImageViewHolder holder : holders) {
            if (holder.position == index) {
//                holder.resetScale();
                break;
            }
        }
    }

    String getUrl(int index) {
        return dataSet.format(index);
    }



    class ImageViewHolder extends ViewHolder {

        private int position = -1;
        private ImageView imageView;
        private boolean isScaled;

        ImageViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView;
        }

        void bind(Context context, int position) {
            this.position = position;

            Glide.with(context).load(dataSet.format(position)).into(imageView);

//
//            tryToSetHierarchy();
//            setController(dataSet.format(position));
//
//            drawee.setOnScaleChangeListener(this);

        }


//
//        void resetScale() {
//            drawee.setScale(1.0f, true);
//        }
//
//        private void tryToSetHierarchy() {
//            if (hierarchyBuilder != null) {
//                hierarchyBuilder.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
//                drawee.setHierarchy(hierarchyBuilder.build());
//            }
//        }
//
//        private void setController(String url) {
//            PipelineDraweeControllerBuilder controllerBuilder = Fresco.newDraweeControllerBuilder();
//            controllerBuilder.setUri(url);
//            controllerBuilder.setAutoPlayAnimations(true);
//            controllerBuilder.setOldController(drawee.getController());
//            controllerBuilder.setControllerListener(getDraweeControllerListener(drawee));
//            if (imageRequestBuilder != null) {
//                imageRequestBuilder.setSource(Uri.parse(url));
//                controllerBuilder.setImageRequest(imageRequestBuilder.build());
//            }
//            drawee.setController(controllerBuilder.build());
//        }

    }
}
