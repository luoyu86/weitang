package c.e.c.p;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.x;
import c.e.e.a.s.e;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.oss.bo.AliYunOssResultVo;
import com.chinavisionary.microtang.db.FoodTableResultVo;
import com.chinavisionary.microtang.db.vo.CacheVo;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.microtang.merchant.vo.BuyCartCountVo;
import com.chinavisionary.microtang.merchant.vo.MerchantRightContentVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1808a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SQLiteDatabase f1809b;

    public static b getInstance() {
        return f1808a;
    }

    public final synchronized boolean a(MerchantRightContentVo.FoodVo foodVo) {
        boolean z;
        if (foodVo != null) {
            SQLiteDatabase sQLiteDatabase = this.f1809b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
                try {
                    z = this.f1809b.delete("food_buy_cart_table", "spec_key = ?", new String[]{foodVo.getBaseKey()}) > 0;
                    this.f1809b.setTransactionSuccessful();
                    this.f1809b.endTransaction();
                } catch (Throwable th) {
                    this.f1809b.endTransaction();
                    throw th;
                }
            }
        }
        return z;
    }

    public final synchronized boolean b(String str) {
        return c(str, null, null);
    }

    public final synchronized boolean c(String str, String str2, String[] strArr) {
        boolean z;
        SQLiteDatabase sQLiteDatabase;
        if (x.isNotNull(str) && (sQLiteDatabase = this.f1809b) != null) {
            sQLiteDatabase.beginTransaction();
            try {
                z = this.f1809b.delete(str, str2, strArr) > 0;
                this.f1809b.setTransactionSuccessful();
                this.f1809b.endTransaction();
            } catch (Throwable th) {
                this.f1809b.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public void closeDb() {
        SQLiteDatabase sQLiteDatabase = this.f1809b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
        this.f1809b = null;
    }

    public final String[] d() {
        return new String[]{"count", "product_key", "spec_key", "price"};
    }

    public synchronized boolean delFoodBuyCartTableData() {
        return b("food_buy_cart_table");
    }

    public final String[] e() {
        return new String[]{"file_path", "pic_url"};
    }

    public final synchronized FoodTableResultVo f(MerchantRightContentVo.FoodVo foodVo) {
        FoodTableResultVo foodTableResultVo;
        foodTableResultVo = null;
        if (foodVo != null) {
            SQLiteDatabase sQLiteDatabase = this.f1809b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
                try {
                    Cursor cursorQuery = this.f1809b.query("food_buy_cart_table", d(), "spec_key = ?", new String[]{foodVo.getBaseKey()}, null, null, null, null);
                    if (cursorQuery.moveToFirst()) {
                        foodTableResultVo = new FoodTableResultVo();
                        foodTableResultVo.setCount(cursorQuery.getInt(cursorQuery.getColumnIndex("count")));
                    }
                    cursorQuery.close();
                    this.f1809b.setTransactionSuccessful();
                    this.f1809b.endTransaction();
                } catch (Throwable th) {
                    this.f1809b.endTransaction();
                    throw th;
                }
            }
        }
        return foodTableResultVo;
    }

    public synchronized CacheVo getCacheVo(String str) {
        CacheVo cacheVo;
        SQLiteDatabase sQLiteDatabase;
        cacheVo = null;
        if (x.isNotNull(str) && (sQLiteDatabase = this.f1809b) != null) {
            sQLiteDatabase.beginTransaction();
            try {
                Cursor cursorQuery = this.f1809b.query("cache_table", new String[]{"cache_value"}, "cache_key = ?", new String[]{str}, null, null, null);
                if (cursorQuery.moveToFirst()) {
                    cacheVo = new CacheVo();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("cache_value"));
                    q.d(getClass().getSimpleName(), "getCacheVo cacheKey = " + str + ",cacheValue = " + string);
                    cacheVo.setCacheKey(str);
                    cacheVo.setCacheValue(string);
                }
                cursorQuery.close();
                this.f1809b.setTransactionSuccessful();
                this.f1809b.endTransaction();
            } catch (Throwable th) {
                this.f1809b.endTransaction();
                throw th;
            }
        }
        return cacheVo;
    }

    public void init(Context context) {
        if (context == null || this.f1809b != null) {
            return;
        }
        try {
            this.f1809b = new a(context).getWritableDatabase();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public synchronized boolean insertCacheVo(String str, String str2) {
        boolean z;
        SQLiteDatabase sQLiteDatabase;
        z = true;
        if (!x.isNotNull(str) || (sQLiteDatabase = this.f1809b) == null) {
            z = false;
        } else {
            sQLiteDatabase.beginTransaction();
            try {
                c("cache_table", "cache_key = ?", new String[]{str});
                q.d(getClass().getSimpleName(), "insertCacheVo cacheKey = " + str + ",cacheValue = " + str2);
                if (x.isNotNull(str2)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("cache_key", str);
                    contentValues.put("cache_value", str2);
                    this.f1809b.insert("cache_table", null, contentValues);
                }
                this.f1809b.setTransactionSuccessful();
                this.f1809b.endTransaction();
            } catch (Throwable th) {
                this.f1809b.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public synchronized boolean insertFoodBuyCart(MerchantRightContentVo.FoodVo foodVo) {
        boolean z;
        if (foodVo != null) {
            SQLiteDatabase sQLiteDatabase = this.f1809b;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
                try {
                    int iFloatValue = (int) (foodVo.getPrice().floatValue() * 100.0f);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("count", Integer.valueOf(foodVo.getBuyNumber()));
                    contentValues.put("product_key", foodVo.getProductKey());
                    contentValues.put("spec_key", foodVo.getBaseKey());
                    contentValues.put("price", Integer.valueOf(iFloatValue));
                    z = this.f1809b.insert("food_buy_cart_table", null, contentValues) > 0;
                    this.f1809b.setTransactionSuccessful();
                    this.f1809b.endTransaction();
                } catch (Throwable th) {
                    this.f1809b.endTransaction();
                    throw th;
                }
            }
        }
        return z;
    }

    public synchronized boolean insertLockSortData(List<e> list, String str) {
        boolean z;
        SQLiteDatabase sQLiteDatabase;
        if (o.isNotEmpty(list) && x.isNotNull(str) && (sQLiteDatabase = this.f1809b) != null) {
            sQLiteDatabase.beginTransaction();
            try {
                c("lock_sort_table", "phone = ?", new String[]{str});
                ContentValues contentValues = new ContentValues();
                contentValues.put(NewLoginBo.SMS_LOGIN_NAME, str);
                contentValues.put("lock_sort_key", JSON.toJSONString(list));
                z = this.f1809b.insert("lock_sort_table", null, contentValues) > 0;
                this.f1809b.setTransactionSuccessful();
                this.f1809b.endTransaction();
            } catch (Throwable th) {
                this.f1809b.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public synchronized boolean insertPicData(List<AliYunOssResultVo> list) {
        boolean z;
        SQLiteDatabase sQLiteDatabase;
        boolean z2;
        z = false;
        if (o.isNotEmpty(list) && (sQLiteDatabase = this.f1809b) != null) {
            sQLiteDatabase.beginTransaction();
            try {
                b("pic_table");
                loop0: while (true) {
                    z2 = false;
                    for (AliYunOssResultVo aliYunOssResultVo : list) {
                        if (aliYunOssResultVo != null && x.isNotNull(aliYunOssResultVo.getPicUrl())) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("file_path", aliYunOssResultVo.getPathName());
                            contentValues.put("pic_url", aliYunOssResultVo.getPicUrl());
                            if (this.f1809b.insert("pic_table", null, contentValues) > 0) {
                                z2 = true;
                            }
                        }
                    }
                }
                this.f1809b.setTransactionSuccessful();
                this.f1809b.endTransaction();
                z = z2;
            } catch (Throwable th) {
                this.f1809b.endTransaction();
                throw th;
            }
        }
        return z;
    }

    public synchronized List<AliYunOssResultVo> queryAilYunOssResultList() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        SQLiteDatabase sQLiteDatabase = this.f1809b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
            try {
                Cursor cursorQuery = this.f1809b.query("pic_table", e(), null, null, null, null, null);
                while (cursorQuery.moveToNext()) {
                    AliYunOssResultVo aliYunOssResultVo = new AliYunOssResultVo();
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("file_path"));
                    aliYunOssResultVo.setPicUrl(cursorQuery.getString(cursorQuery.getColumnIndex("pic_url")));
                    aliYunOssResultVo.setPathName(string);
                    arrayList.add(aliYunOssResultVo);
                }
                cursorQuery.close();
                this.f1809b.setTransactionSuccessful();
                this.f1809b.endTransaction();
            } catch (Throwable th) {
                this.f1809b.endTransaction();
                throw th;
            }
        }
        return arrayList;
    }

    public synchronized BuyCartCountVo queryFoodTableCountResultVo() {
        BuyCartCountVo buyCartCountVo;
        buyCartCountVo = null;
        SQLiteDatabase sQLiteDatabase = this.f1809b;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.beginTransaction();
            try {
                Cursor cursorQuery = this.f1809b.query("food_buy_cart_table", d(), null, null, null, null, null, null);
                int i2 = 0;
                int i3 = 0;
                while (cursorQuery.moveToNext()) {
                    int i4 = cursorQuery.getInt(cursorQuery.getColumnIndex("count"));
                    i2 += cursorQuery.getInt(cursorQuery.getColumnIndex("price")) * i4;
                    i3 += i4;
                }
                BuyCartCountVo buyCartCountVo2 = new BuyCartCountVo();
                buyCartCountVo2.setBuyCountPrice(new BigDecimal(String.valueOf(i2 / 100.0f)));
                buyCartCountVo2.setBuyCount(i3);
                cursorQuery.close();
                this.f1809b.setTransactionSuccessful();
                this.f1809b.endTransaction();
                buyCartCountVo = buyCartCountVo2;
            } catch (Throwable th) {
                this.f1809b.endTransaction();
                throw th;
            }
        }
        return buyCartCountVo;
    }

    public synchronized List<e> queryLockSortListToPhone(String str) {
        List<e> array;
        SQLiteDatabase sQLiteDatabase;
        array = null;
        if (x.isNotNull(str) && (sQLiteDatabase = this.f1809b) != null) {
            Cursor cursorQuery = sQLiteDatabase.query("lock_sort_table", new String[]{"lock_sort_key"}, "phone = ?", new String[]{str}, null, null, null);
            if (cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("lock_sort_key"));
                if (x.isNotNull(string)) {
                    array = JSON.parseArray(string, e.class);
                }
            }
            cursorQuery.close();
        }
        return array;
    }

    public synchronized boolean updateFoodBuyCart(MerchantRightContentVo.FoodVo foodVo) {
        boolean zInsertFoodBuyCart;
        if (foodVo != null) {
            if (this.f1809b != null) {
                FoodTableResultVo foodTableResultVoF = f(foodVo);
                if (foodTableResultVoF == null) {
                    zInsertFoodBuyCart = insertFoodBuyCart(foodVo);
                } else if (foodVo.getBuyNumber() == 0) {
                    zInsertFoodBuyCart = a(foodVo);
                } else {
                    this.f1809b.beginTransaction();
                    try {
                        int iFloatValue = (int) (foodVo.getPrice().floatValue() * 100.0f);
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("count", Integer.valueOf(foodVo.getBuyNumber() + foodTableResultVoF.getCount()));
                        contentValues.put("product_key", foodVo.getProductKey());
                        contentValues.put("spec_key", foodVo.getBaseKey());
                        contentValues.put("price", Integer.valueOf(iFloatValue));
                        zInsertFoodBuyCart = this.f1809b.update("food_buy_cart_table", contentValues, "spec_key = ?", new String[]{foodVo.getBaseKey()}) > 0;
                        this.f1809b.setTransactionSuccessful();
                        this.f1809b.endTransaction();
                    } catch (Throwable th) {
                        this.f1809b.endTransaction();
                        throw th;
                    }
                }
            }
        }
        return zInsertFoodBuyCart;
    }
}
