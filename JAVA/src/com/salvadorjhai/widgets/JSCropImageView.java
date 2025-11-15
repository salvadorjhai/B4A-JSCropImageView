package com.salvadorjhai.widgets;

import com.theartofdev.edmodo.cropper.CropImageView;
import com.theartofdev.edmodo.cropper.CropImageView.CropResult;
import com.theartofdev.edmodo.cropper.CropImageView.CropShape;
import com.theartofdev.edmodo.cropper.CropImageView.Guidelines;
import com.theartofdev.edmodo.cropper.CropImageView.OnCropImageCompleteListener;
import com.theartofdev.edmodo.cropper.CropImageView.RequestSizeOptions;
import com.theartofdev.edmodo.cropper.CropImageView.ScaleType;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.Author;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.keywords.Common.DesignerCustomView;
import anywheresoftware.b4a.objects.CustomViewWrapper;
import anywheresoftware.b4a.objects.LabelWrapper;
import anywheresoftware.b4a.objects.PanelWrapper;
import anywheresoftware.b4a.objects.ViewWrapper;
import anywheresoftware.b4a.objects.collections.Map;

/**
 * The Class JSCropImageView.
 */
@ShortName("JSCropImageView")
@Version(0.1F)
@Author("salvadorjhai")
@Events(values = { "OnCropImageComplete(view As JSCropImageView, result As JSCropResult)" })
@DependsOn(values = { "JSAndroid-Image-Cropper.aar", "android-support-v4", "android-support-annotations" })
@ActivityObject
public class JSCropImageView extends ViewWrapper<CropImageView> implements DesignerCustomView {

	private BA mBA = null;
	private String mEventName = "";

	@Override
	public void Initialize(BA ba, String eventName) {
		_initialize(ba, null, eventName);
	}

	@Override
	@BA.Hide
	public void _initialize(BA ba, Object paramObject, String eventName) {
		innerInitialize(ba, eventName, false);
	}

	@Override
	@BA.Hide
	public void innerInitialize(final BA ba, final String eventName, boolean keepOldObject) {
		this.mBA = ba;
		this.mEventName = eventName;

		try {
			// set object and props
			if (!keepOldObject) {
				this.setObject(new CropImageView(ba.context));
			}

			// Inner Initialize
			super.innerInitialize(ba, eventName, true);

			// Set event Listeners
			if (eventName.length() != 0) {
				this.getObjectOrNull().setOnCropImageCompleteListener(new OnCropImageCompleteListener() {
					
					@Override
					public void onCropImageComplete(CropImageView view, CropResult result) {
						JSCropResult res = new JSCropResult();
						res.setObject(result);
						
						try {
							String event = mEventName + "_OnCropImageComplete";
							ba.raiseEvent(this, event.toLowerCase(BA.cul), new Object[] {view, res});
						} catch (Exception e) {
							mBA.setLastException(e);
							BA.LogError(e.getMessage());
						}
						
					}
				});
				
			}

		} catch (Exception e) {
			ba.setLastException(e);
			BA.LogError(e.getMessage());
		}
	}

	@Override
	public void DesignerCreateView(PanelWrapper paramPanelWrapper, LabelWrapper paramLabelWrapper, Map paramMap) {
		CustomViewWrapper.replaceBaseWithView2(paramPanelWrapper, this.getObjectOrNull());
	}

	/**
	 * Gets the scale type.
	 *
	 * @return the scale type
	 */
	public int getScaleType() {
		return JSScaleType.getScaleType(this.getObjectOrNull().getScaleType());
	}

	/**
	 * Sets the scale type.
	 *
	 * @param scaleType
	 *            the new scale type
	 */
	public void setScaleType(int scaleType) {
		this.getObjectOrNull().setScaleType(JSScaleType.getScaleType(scaleType));
	}

	/**
	 * Gets the crop shape.
	 *
	 * @return the crop shape
	 */
	public int getCropShape() {
		return JSCropShape.get(this.getObjectOrNull().getCropShape());
	}

	/**
	 * Sets the crop shape.
	 *
	 * @param cropShape
	 *            the new crop shape
	 */
	public void setCropShape(int cropShape) {
		this.getObjectOrNull().setCropShape(JSCropShape.get(cropShape));
	}

	/**
	 * Checks if is auto zoom enabled.
	 *
	 * @return true, if is auto zoom enabled
	 */
	public boolean isAutoZoomEnabled() {
		return this.getObjectOrNull().isAutoZoomEnabled();
	}

	/**
	 * Sets the auto zoom enabled.
	 *
	 * @param autoZoomEnabled
	 *            the new auto zoom enabled
	 */
	public void setAutoZoomEnabled(boolean autoZoomEnabled) {
		this.getObjectOrNull().setAutoZoomEnabled(autoZoomEnabled);
	}

	/**
	 * Sets the multi touch enabled.
	 *
	 * @param multiTouchEnabled
	 *            the new multi touch enabled
	 */
	public void setMultiTouchEnabled(boolean multiTouchEnabled) {
		this.getObjectOrNull().setMultiTouchEnabled(multiTouchEnabled);
	}

	/**
	 * Gets the max zoom.
	 *
	 * @return the max zoom
	 */
	public int getMaxZoom() {
		return this.getObjectOrNull().getMaxZoom();
	}

	/**
	 * Sets the max zoom.
	 *
	 * @param maxZoom
	 *            the new max zoom
	 */
	public void setMaxZoom(int maxZoom) {
		this.getObjectOrNull().setMaxZoom(maxZoom);
	}

	/**
	 * Sets the min crop result size.
	 *
	 * @param minCropResultWidth
	 *            the min crop result width
	 * @param minCropResultHeight
	 *            the min crop result height
	 */
	public void setMinCropResultSize(int minCropResultWidth, int minCropResultHeight) {
		this.getObjectOrNull().setMinCropResultSize(minCropResultWidth, minCropResultHeight);
	}

	/**
	 * Sets the max crop result size.
	 *
	 * @param maxCropResultWidth
	 *            the max crop result width
	 * @param maxCropResultHeight
	 *            the max crop result height
	 */
	public void setMaxCropResultSize(int maxCropResultWidth, int maxCropResultHeight) {
		this.getObjectOrNull().setMaxCropResultSize(maxCropResultWidth, maxCropResultHeight);
	}

	/**
	 * Gets the rotated degrees.
	 *
	 * @return the rotated degrees
	 */
	public int getRotatedDegrees() {
		return this.getObjectOrNull().getRotatedDegrees();
	}

	/**
	 * Sets the rotated degrees.
	 *
	 * @param degrees
	 *            the new rotated degrees
	 */
	public void setRotatedDegrees(int degrees) {
		this.getObjectOrNull().setRotatedDegrees(degrees);
	}

	/**
	 * Checks if is fix aspect ratio.
	 *
	 * @return true, if is fix aspect ratio
	 */
	public boolean isFixAspectRatio() {
		return this.getObjectOrNull().isFixAspectRatio();
	}

	/**
	 * Sets the fixed aspect ratio.
	 *
	 * @param fixAspectRatio
	 *            the new fixed aspect ratio
	 */
	public void setFixedAspectRatio(boolean fixAspectRatio) {
		this.getObjectOrNull().setFixedAspectRatio(fixAspectRatio);
	}

	/**
	 * Gets the guidelines.
	 *
	 * @return the guidelines
	 */
	public int getGuidelines() {
		return JSGuidelines.getGuidelines(this.getObjectOrNull().getGuidelines());
	}

	/**
	 * Sets the guidelines.
	 *
	 * @param guidelines
	 *            the new guidelines
	 */
	public void setGuidelines(int guidelines) {
		this.getObjectOrNull().setGuidelines(JSGuidelines.getGuidelines(guidelines));
	}

	/**
	 * Gets the aspect ratio.
	 *
	 * @return the aspect ratio
	 */
	public int[] getAspectRatio() {
		Pair<Integer, Integer> p = this.getObjectOrNull().getAspectRatio();
		return new int[] {(int)p.first, (int)p.second};
	}

	/**
	 * Sets the aspect ratio.
	 *
	 * @param aspectRatioX
	 *            the aspect ratio X
	 * @param aspectRatioY
	 *            the aspect ratio Y
	 */
	public void setAspectRatio(int aspectRatioX, int aspectRatioY) {
		this.getObjectOrNull().setAspectRatio(aspectRatioX, aspectRatioY);
	}

	/**
	 * Clear aspect ratio.
	 */
	public void clearAspectRatio() {
		this.getObjectOrNull().clearAspectRatio();
	}

	/**
	 * Sets the snap radius.
	 *
	 * @param snapRadius
	 *            the new snap radius
	 */
	public void setSnapRadius(float snapRadius) {
		this.getObjectOrNull().setSnapRadius(snapRadius);
	}

	/**
	 * Checks if is show progress bar.
	 *
	 * @return true, if is show progress bar
	 */
	public boolean isShowProgressBar() {
		return this.getObjectOrNull().isShowProgressBar();
	}

	/**
	 * Sets the show progress bar.
	 *
	 * @param showProgressBar
	 *            the new show progress bar
	 */
	public void setShowProgressBar(boolean showProgressBar) {
		this.getObjectOrNull().setShowProgressBar(showProgressBar);
	}

	/**
	 * Checks if is show crop overlay.
	 *
	 * @return true, if is show crop overlay
	 */
	public boolean isShowCropOverlay() {
		return this.getObjectOrNull().isShowCropOverlay();
	}

	/**
	 * Sets the show crop overlay.
	 *
	 * @param showCropOverlay
	 *            the new show crop overlay
	 */
	public void setShowCropOverlay(boolean showCropOverlay) {
		this.getObjectOrNull().setShowCropOverlay(showCropOverlay);
	}

	/**
	 * Gets the crop rect.
	 *
	 * @return the crop rect
	 */
	public Rect getCropRect() {
		return this.getObjectOrNull().getCropRect();
	}

	/**
	 * Gets the crop points.
	 *
	 * @return the crop points
	 */
	public float[] getCropPoints() {
		return this.getObjectOrNull().getCropPoints();
	}

	/**
	 * Sets the crop rect.
	 *
	 * @param rect
	 *            the new crop rect
	 */
	public void setCropRect(Rect rect) {
		this.getObjectOrNull().setCropRect(rect);
	}

	/**
	 * Reset crop rect.
	 */
	public void resetCropRect() {
		this.getObjectOrNull().resetCropRect();
	}

	/**
	 * Gets the cropped image.
	 *
	 * @return the cropped image
	 */
	public Bitmap getCroppedImage() {
		return this.getObjectOrNull().getCroppedImage();
	}

	/**
	 * Gets the cropped image.
	 *
	 * @param reqWidth
	 *            the req width
	 * @param reqHeight
	 *            the req height
	 * @return the cropped image
	 */
	public Bitmap getCroppedImage2(int reqWidth, int reqHeight) {
		return this.getObjectOrNull().getCroppedImage(reqWidth, reqHeight);
	}

	/**
	 * Gets the cropped image.
	 *
	 * @param reqWidth
	 *            the req width
	 * @param reqHeight
	 *            the req height
	 * @param options
	 *            the options
	 * @return the cropped image
	 */
	public Bitmap getCroppedImage3(int reqWidth, int reqHeight, RequestSizeOptions options) {
		return this.getObjectOrNull().getCroppedImage(reqWidth, reqHeight, options);
	}

	/**
	 * Gets the cropped image async.
	 *
	 * @return the cropped image async
	 */
	public void getCroppedImageAsync() {
		this.getObjectOrNull().getCroppedImageAsync();
	}

	/**
	 * Gets the cropped image async.
	 *
	 * @param reqWidth
	 *            the req width
	 * @param reqHeight
	 *            the req height
	 * @return the cropped image async
	 */
	public void getCroppedImageAsync2(int reqWidth, int reqHeight) {
		this.getObjectOrNull().getCroppedImageAsync(reqWidth, reqHeight);
	}

	/**
	 * Gets the cropped image async.
	 *
	 * @param reqWidth
	 *            the req width
	 * @param reqHeight
	 *            the req height
	 * @param options
	 *            the options
	 * @return the cropped image async
	 */
	public void getCroppedImageAsync3(int reqWidth, int reqHeight, RequestSizeOptions options) {
		this.getObjectOrNull().getCroppedImageAsync(reqWidth, reqHeight, options);
	}

	/**
	 * Sets the image bitmap.
	 *
	 * @param bitmap
	 *            the new image bitmap
	 */
	public void setImageBitmap(Bitmap bitmap) {
		this.getObjectOrNull().setImageBitmap(bitmap);
	}

	/**
	 * Clear image.
	 */
	public void clearImage() {
		this.getObjectOrNull().clearImage();
	}

	/**
	 * Rotate image.
	 *
	 * @param degrees
	 *            the degrees
	 */
	public void rotateImage(int degrees) {
		this.getObjectOrNull().rotateImage(degrees);
	}
	
	/**
     * Options for scaling the bounds of cropping image to the bounds of Crop Image View.<br>
     * Note: Some options are affected by auto-zoom, if enabled.
     */
	@ShortName("ScaleType")
	public static final class JSScaleType {
		/**
         * Scale the image uniformly (maintain the image's aspect ratio) to fit in crop image view.<br>
         * The largest dimension will be equals to crop image view and the second dimension will be smaller.
         */
        public static final int FIT_CENTER = 0;

        /**
         * Center the image in the view, but perform no scaling.<br>
         * Note: If auto-zoom is enabled and the source image is smaller than crop image view then it will be
         * scaled uniformly to fit the crop image view.
         */
        public static final int CENTER = 1;

        /**
         * Scale the image uniformly (maintain the image's aspect ratio) so that both
         * dimensions (width and height) of the image will be equal to or <b>larger</b> than the
         * corresponding dimension of the view (minus padding).<br>
         * The image is then centered in the view.
         */
        public static final int CENTER_CROP = 2;

        /**
         * Scale the image uniformly (maintain the image's aspect ratio) so that both
         * dimensions (width and height) of the image will be equal to or <b>less</b> than the
         * corresponding dimension of the view (minus padding).<br>
         * The image is then centered in the view.<br>
         * Note: If auto-zoom is enabled and the source image is smaller than crop image view then it will be
         * scaled uniformly to fit the crop image view.
         */
        public static final int CENTER_INSIDE = 3;
        
        @Hide
        public static ScaleType getScaleType(int value) {
        	switch (value) {
        	case CENTER: return ScaleType.CENTER;
        	case CENTER_CROP: return ScaleType.CENTER_CROP;
        	case CENTER_INSIDE: return ScaleType.CENTER_INSIDE;
	        	default:
	        		return ScaleType.FIT_CENTER;
        	}
        }
        
        @Hide
        public static int getScaleType(ScaleType value) {
        	switch (value) {
        	case CENTER: return CENTER;
        	case CENTER_CROP: return CENTER_CROP;
        	case CENTER_INSIDE: return CENTER_INSIDE;
	        	default:
	        		return FIT_CENTER;
        	}
        }        
	}
	
	/**
     * The possible guidelines showing types.
     */
	@ShortName("Guidelines")
	public static final class JSGuidelines {
        /**
         * Never show
         */
		public static final int OFF = 0;

        /**
         * Show when crop move action is live
         */
		public static final int ON_TOUCH = 2;

        /**
         * Always show
         */
		public static final int ON = 1;
		
		@Hide
        public static Guidelines getGuidelines(int value) {
        	switch (value) {
        	case ON: return Guidelines.ON;
        	case ON_TOUCH: return Guidelines.ON_TOUCH;
	        	default:
	        		return Guidelines.OFF;
        	}
        }
        
        @Hide
        public static int getGuidelines(Guidelines value) {
        	switch (value) {
        	case ON: return ON;
        	case ON_TOUCH: return ON_TOUCH;
	        	default:
	        		return OFF;
        	}
        }	
    }
	
	/**
     * The possible cropping area shape.<br>
     * To set square/circle crop shape set aspect ratio to 1:1.
     */
	@ShortName("CropShape")
    public static final class JSCropShape {
        public static final int RECTANGLE = 0;
        public static final int OVAL = 1;
        
        @Hide
        public static CropShape get(int value) {
        	switch (value) {
        	case OVAL: return CropShape.OVAL;
	        	default:
	        		return CropShape.RECTANGLE;
        	}
        }
        
        @Hide
        public static int get(CropShape value) {
        	switch (value) {
        	case OVAL: return OVAL;
	        	default:
	        		return RECTANGLE;
        	}
        }
        
    }
	
	/**
     * Result data of crop image.
     */
	@ShortName("CropResult")
	public class JSCropResult extends AbsObjectWrapper<CropResult> {
		/**
         * Is the result is success or error.
         */
        public boolean isSuccessful() {
            return this.getObjectOrNull().getError() == null;
        }

        /**
         * The cropped image bitmap result.<br>
         * Null if save cropped image was executed, no output requested or failure.
         */
        public Bitmap getBitmap() {
            return this.getObjectOrNull().getBitmap();
        }
     
        /**
         * The error that failed the loading/cropping (null if successful)
         */
        public Exception getError() {
            return this.getObjectOrNull().getError();
        }

        /**
         * The 4 points of the cropping window in the source image
         */
        public float[] getCropPoints() {
            return this.getObjectOrNull().getCropPoints();
        }

        /**
         * The rectangle of the cropping window in the source image
         */
        public Rect getCropRect() {
            return this.getObjectOrNull().getCropRect();
        }

        /**
         * The final rotation of the cropped image relative to source
         */
        public int getRotation() {
            return this.getObjectOrNull().getRotation();
        }

        /**
         * sample size used creating the crop bitmap to lower its size
         */
        public int getSampleSize() {
            return this.getObjectOrNull().getSampleSize();
        }
		
	}

}
