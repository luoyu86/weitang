package com.google.android.material.floatingactionbutton;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.CircularBorderDrawable;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.google.android.material.shadow.ShadowViewDelegate;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class FloatingActionButtonImpl {
    public static final int ANIM_STATE_HIDING = 1;
    public static final int ANIM_STATE_NONE = 0;
    public static final int ANIM_STATE_SHOWING = 2;
    public static final long ELEVATION_ANIM_DELAY = 100;
    public static final long ELEVATION_ANIM_DURATION = 100;
    private static final float HIDE_ICON_SCALE = 0.0f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.0f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    public CircularBorderDrawable borderDrawable;
    public Drawable contentBackground;

    @Nullable
    public Animator currentAnimator;

    @Nullable
    private MotionSpec defaultHideMotionSpec;

    @Nullable
    private MotionSpec defaultShowMotionSpec;
    public float elevation;
    private ArrayList<Animator.AnimatorListener> hideListeners;

    @Nullable
    public MotionSpec hideMotionSpec;
    public float hoveredFocusedTranslationZ;
    public int maxImageSize;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    public float pressedTranslationZ;
    public Drawable rippleDrawable;
    private float rotation;
    public ShadowDrawableWrapper shadowDrawable;
    public final ShadowViewDelegate shadowViewDelegate;
    public Drawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;

    @Nullable
    public MotionSpec showMotionSpec;
    private final StateListAnimator stateListAnimator;
    public final VisibilityAwareImageButton view;
    public static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    public static final int[] PRESSED_ENABLED_STATE_SET = {R.attr.state_pressed, R.attr.state_enabled};
    public static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};
    public static final int[] FOCUSED_ENABLED_STATE_SET = {R.attr.state_focused, R.attr.state_enabled};
    public static final int[] HOVERED_ENABLED_STATE_SET = {R.attr.state_hovered, R.attr.state_enabled};
    public static final int[] ENABLED_STATE_SET = {R.attr.state_enabled};
    public static final int[] EMPTY_STATE_SET = new int[0];
    public int animState = 0;
    public float imageMatrixScale = 1.0f;
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();
    private final Matrix tmpMatrix = new Matrix();

    public class DisabledElevationAnimation extends ShadowAnimatorImpl {
        public DisabledElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return 0.0f;
        }
    }

    public class ElevateToHoveredFocusedTranslationZAnimation extends ShadowAnimatorImpl {
        public ElevateToHoveredFocusedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.hoveredFocusedTranslationZ;
        }
    }

    public class ElevateToPressedTranslationZAnimation extends ShadowAnimatorImpl {
        public ElevateToPressedTranslationZAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
            return floatingActionButtonImpl.elevation + floatingActionButtonImpl.pressedTranslationZ;
        }
    }

    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    public class ResetElevationAnimation extends ShadowAnimatorImpl {
        public ResetElevationAnimation() {
            super();
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
        public float getTargetShadowSize() {
            return FloatingActionButtonImpl.this.elevation;
        }
    }

    public abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private float shadowSizeEnd;
        private float shadowSizeStart;
        private boolean validValues;

        private ShadowAnimatorImpl() {
        }

        public abstract float getTargetShadowSize();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.shadowDrawable.setShadowSize(this.shadowSizeEnd);
            this.validValues = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.validValues) {
                this.shadowSizeStart = FloatingActionButtonImpl.this.shadowDrawable.getShadowSize();
                this.shadowSizeEnd = getTargetShadowSize();
                this.validValues = true;
            }
            ShadowDrawableWrapper shadowDrawableWrapper = FloatingActionButtonImpl.this.shadowDrawable;
            float f2 = this.shadowSizeStart;
            shadowDrawableWrapper.setShadowSize(f2 + ((this.shadowSizeEnd - f2) * valueAnimator.getAnimatedFraction()));
        }
    }

    public FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        this.view = visibilityAwareImageButton;
        this.shadowViewDelegate = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.stateListAnimator = stateListAnimator;
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToPressedTranslationZAnimation()));
        stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(new ElevateToHoveredFocusedTranslationZAnimation()));
        stateListAnimator.addState(ENABLED_STATE_SET, createElevationAnimator(new ResetElevationAnimation()));
        stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(new DisabledElevationAnimation()));
        this.rotation = visibilityAwareImageButton.getRotation();
    }

    private void calculateImageMatrixFromScale(float f2, Matrix matrix) {
        matrix.reset();
        if (this.view.getDrawable() == null || this.maxImageSize == 0) {
            return;
        }
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i2 = this.maxImageSize;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.maxImageSize;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    @NonNull
    private AnimatorSet createAnimator(@NonNull MotionSpec motionSpec, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.view, (Property<VisibilityAwareImageButton, Float>) View.ALPHA, f2);
        motionSpec.getTiming("opacity").apply(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.view, (Property<VisibilityAwareImageButton, Float>) View.SCALE_X, f3);
        motionSpec.getTiming("scale").apply(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.view, (Property<VisibilityAwareImageButton, Float>) View.SCALE_Y, f3);
        motionSpec.getTiming("scale").apply(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        calculateImageMatrixFromScale(f4, this.tmpMatrix);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator(), new Matrix(this.tmpMatrix));
        motionSpec.getTiming("iconScale").apply(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator createElevationAnimator(@NonNull ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void ensurePreDrawListener() {
        if (this.preDrawListener == null) {
            this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.onPreDraw();
                    return true;
                }
            };
        }
    }

    private MotionSpec getDefaultHideMotionSpec() {
        if (this.defaultHideMotionSpec == null) {
            this.defaultHideMotionSpec = MotionSpec.createFromResource(this.view.getContext(), com.google.android.material.R.animator.design_fab_hide_motion_spec);
        }
        return this.defaultHideMotionSpec;
    }

    private MotionSpec getDefaultShowMotionSpec() {
        if (this.defaultShowMotionSpec == null) {
            this.defaultShowMotionSpec = MotionSpec.createFromResource(this.view.getContext(), com.google.android.material.R.animator.design_fab_show_motion_spec);
        }
        return this.defaultShowMotionSpec;
    }

    private boolean shouldAnimateVisibilityChange() {
        return ViewCompat.isLaidOut(this.view) && !this.view.isInEditMode();
    }

    private void updateFromViewRotation() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.rotation % 90.0f != 0.0f) {
                if (this.view.getLayerType() != 1) {
                    this.view.setLayerType(1, null);
                }
            } else if (this.view.getLayerType() != 0) {
                this.view.setLayerType(0, null);
            }
        }
        ShadowDrawableWrapper shadowDrawableWrapper = this.shadowDrawable;
        if (shadowDrawableWrapper != null) {
            shadowDrawableWrapper.setRotation(-this.rotation);
        }
        CircularBorderDrawable circularBorderDrawable = this.borderDrawable;
        if (circularBorderDrawable != null) {
            circularBorderDrawable.setRotation(-this.rotation);
        }
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new ArrayList<>();
        }
        this.hideListeners.add(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new ArrayList<>();
        }
        this.showListeners.add(animatorListener);
    }

    public CircularBorderDrawable createBorderDrawable(int i2, ColorStateList colorStateList) {
        Context context = this.view.getContext();
        CircularBorderDrawable circularBorderDrawableNewCircularDrawable = newCircularDrawable();
        circularBorderDrawableNewCircularDrawable.setGradientColors(ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, com.google.android.material.R.color.design_fab_stroke_end_outer_color));
        circularBorderDrawableNewCircularDrawable.setBorderWidth(i2);
        circularBorderDrawableNewCircularDrawable.setBorderTint(colorStateList);
        return circularBorderDrawableNewCircularDrawable;
    }

    public GradientDrawable createShapeDrawable() {
        GradientDrawable gradientDrawableNewGradientDrawableForShape = newGradientDrawableForShape();
        gradientDrawableNewGradientDrawableForShape.setShape(1);
        gradientDrawableNewGradientDrawableForShape.setColor(-1);
        return gradientDrawableNewGradientDrawableForShape;
    }

    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    public float getElevation() {
        return this.elevation;
    }

    @Nullable
    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    public void getPadding(Rect rect) {
        this.shadowDrawable.getPadding(rect);
    }

    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    @Nullable
    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public void hide(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        if (isOrWillBeHidden()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (!shouldAnimateVisibilityChange()) {
            this.view.internalSetVisibility(z ? 8 : 4, z);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onHidden();
                return;
            }
            return;
        }
        MotionSpec defaultHideMotionSpec = this.hideMotionSpec;
        if (defaultHideMotionSpec == null) {
            defaultHideMotionSpec = getDefaultHideMotionSpec();
        }
        AnimatorSet animatorSetCreateAnimator = createAnimator(defaultHideMotionSpec, 0.0f, 0.0f, 0.0f);
        animatorSetCreateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
            private boolean cancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.animState = 0;
                floatingActionButtonImpl.currentAnimator = null;
                if (this.cancelled) {
                    return;
                }
                VisibilityAwareImageButton visibilityAwareImageButton = floatingActionButtonImpl.view;
                boolean z2 = z;
                visibilityAwareImageButton.internalSetVisibility(z2 ? 8 : 4, z2);
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.onHidden();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl.this.view.internalSetVisibility(0, z);
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.animState = 1;
                floatingActionButtonImpl.currentAnimator = animator2;
                this.cancelled = false;
            }
        });
        ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetCreateAnimator.addListener(it.next());
            }
        }
        animatorSetCreateAnimator.start();
    }

    public boolean isOrWillBeHidden() {
        return this.view.getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    public boolean isOrWillBeShown() {
        return this.view.getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    public void jumpDrawableToCurrentState() {
        this.stateListAnimator.jumpToCurrentState();
    }

    public CircularBorderDrawable newCircularDrawable() {
        return new CircularBorderDrawable();
    }

    public GradientDrawable newGradientDrawableForShape() {
        return new GradientDrawable();
    }

    public void onAttachedToWindow() {
        if (requirePreDrawListener()) {
            ensurePreDrawListener();
            this.view.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
        }
    }

    public void onCompatShadowChanged() {
    }

    public void onDetachedFromWindow() {
        if (this.preDrawListener != null) {
            this.view.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
            this.preDrawListener = null;
        }
    }

    public void onDrawableStateChanged(int[] iArr) {
        this.stateListAnimator.setState(iArr);
    }

    public void onElevationsChanged(float f2, float f3, float f4) {
        ShadowDrawableWrapper shadowDrawableWrapper = this.shadowDrawable;
        if (shadowDrawableWrapper != null) {
            shadowDrawableWrapper.setShadowSize(f2, this.pressedTranslationZ + f2);
            updatePadding();
        }
    }

    public void onPaddingUpdated(Rect rect) {
    }

    public void onPreDraw() {
        float rotation = this.view.getRotation();
        if (this.rotation != rotation) {
            this.rotation = rotation;
            updateFromViewRotation();
        }
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public boolean requirePreDrawListener() {
        return true;
    }

    public void setBackgroundDrawable(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable[] drawableArr;
        Drawable drawableWrap = DrawableCompat.wrap(createShapeDrawable());
        this.shapeDrawable = drawableWrap;
        DrawableCompat.setTintList(drawableWrap, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.shapeDrawable, mode);
        }
        Drawable drawableWrap2 = DrawableCompat.wrap(createShapeDrawable());
        this.rippleDrawable = drawableWrap2;
        DrawableCompat.setTintList(drawableWrap2, RippleUtils.convertToRippleDrawableColor(colorStateList2));
        if (i2 > 0) {
            CircularBorderDrawable circularBorderDrawableCreateBorderDrawable = createBorderDrawable(i2, colorStateList);
            this.borderDrawable = circularBorderDrawableCreateBorderDrawable;
            drawableArr = new Drawable[]{circularBorderDrawableCreateBorderDrawable, this.shapeDrawable, this.rippleDrawable};
        } else {
            this.borderDrawable = null;
            drawableArr = new Drawable[]{this.shapeDrawable, this.rippleDrawable};
        }
        this.contentBackground = new LayerDrawable(drawableArr);
        Context context = this.view.getContext();
        Drawable drawable = this.contentBackground;
        float radius = this.shadowViewDelegate.getRadius();
        float f2 = this.elevation;
        ShadowDrawableWrapper shadowDrawableWrapper = new ShadowDrawableWrapper(context, drawable, radius, f2, f2 + this.pressedTranslationZ);
        this.shadowDrawable = shadowDrawableWrapper;
        shadowDrawableWrapper.setAddPaddingForCorners(false);
        this.shadowViewDelegate.setBackgroundDrawable(this.shadowDrawable);
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Drawable drawable = this.shapeDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
        }
        CircularBorderDrawable circularBorderDrawable = this.borderDrawable;
        if (circularBorderDrawable != null) {
            circularBorderDrawable.setBorderTint(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.shapeDrawable;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
        }
    }

    public final void setElevation(float f2) {
        if (this.elevation != f2) {
            this.elevation = f2;
            onElevationsChanged(f2, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    public final void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public final void setHoveredFocusedTranslationZ(float f2) {
        if (this.hoveredFocusedTranslationZ != f2) {
            this.hoveredFocusedTranslationZ = f2;
            onElevationsChanged(this.elevation, f2, this.pressedTranslationZ);
        }
    }

    public final void setImageMatrixScale(float f2) {
        this.imageMatrixScale = f2;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f2, matrix);
        this.view.setImageMatrix(matrix);
    }

    public final void setMaxImageSize(int i2) {
        if (this.maxImageSize != i2) {
            this.maxImageSize = i2;
            updateImageMatrixScale();
        }
    }

    public final void setPressedTranslationZ(float f2) {
        if (this.pressedTranslationZ != f2) {
            this.pressedTranslationZ = f2;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, f2);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.convertToRippleDrawableColor(colorStateList));
        }
    }

    public final void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public void show(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        if (isOrWillBeShown()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (!shouldAnimateVisibilityChange()) {
            this.view.internalSetVisibility(0, z);
            this.view.setAlpha(1.0f);
            this.view.setScaleY(1.0f);
            this.view.setScaleX(1.0f);
            setImageMatrixScale(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onShown();
                return;
            }
            return;
        }
        if (this.view.getVisibility() != 0) {
            this.view.setAlpha(0.0f);
            this.view.setScaleY(0.0f);
            this.view.setScaleX(0.0f);
            setImageMatrixScale(0.0f);
        }
        MotionSpec defaultShowMotionSpec = this.showMotionSpec;
        if (defaultShowMotionSpec == null) {
            defaultShowMotionSpec = getDefaultShowMotionSpec();
        }
        AnimatorSet animatorSetCreateAnimator = createAnimator(defaultShowMotionSpec, 1.0f, 1.0f, 1.0f);
        animatorSetCreateAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.animState = 0;
                floatingActionButtonImpl.currentAnimator = null;
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.onShown();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl.this.view.internalSetVisibility(0, z);
                FloatingActionButtonImpl floatingActionButtonImpl = FloatingActionButtonImpl.this;
                floatingActionButtonImpl.animState = 2;
                floatingActionButtonImpl.currentAnimator = animator2;
            }
        });
        ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetCreateAnimator.addListener(it.next());
            }
        }
        animatorSetCreateAnimator.start();
    }

    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    public final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
