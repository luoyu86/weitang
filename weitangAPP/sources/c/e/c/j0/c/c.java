package c.e.c.j0.c;

import c.e.a.d.x;
import com.chinavisionary.core.app.config.bo.LeftTitleToRightArrowVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.contract.vo.ResponseSignMainInfoVo;
import com.chinavisionary.microtang.contract.vo.SignMainInfoVo;
import com.chinavisionary.microtang.contract.vo.UpdateTogetherLiveBo;
import com.chinavisionary.microtang.room.vo.CheckTogetherVo;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c {
    public final List<ContactDetailsVo.RoommatesBean> a(int i2) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(new ContactDetailsVo.RoommatesBean());
        }
        return arrayList;
    }

    public final List<SignMainInfoVo.RoommatesBean> b(List<ContactDetailsVo.RoommatesBean> list) {
        ArrayList arrayList = new ArrayList();
        for (ContactDetailsVo.RoommatesBean roommatesBean : list) {
            if (roommatesBean != null && x.isNotNull(roommatesBean.getIdCardBackKey()) && x.isNotNull(roommatesBean.getIdCardFrontKey())) {
                SignMainInfoVo.RoommatesBean roommatesBean2 = new SignMainInfoVo.RoommatesBean();
                roommatesBean2.setIdCardBack(roommatesBean.getIdCardBackKey());
                roommatesBean2.setIdCardFront(roommatesBean.getIdCardFrontKey());
                roommatesBean2.setIdCardNo(x.trimAll(roommatesBean.getIdCardNo()));
                roommatesBean2.setPhone(x.trimAll(roommatesBean.getPhone()));
                roommatesBean2.setName(roommatesBean.getName());
                arrayList.add(roommatesBean2);
            }
        }
        return arrayList;
    }

    public final String c(int i2, int i3) {
        return i2 == 1 ? x.getString(R.string.title_together_person_name) : x.appendStringToResId(R.string.placeholder_tip_together_person_is_empty, String.valueOf(i3 + 1));
    }

    public List<LeftTitleToRightArrowVo> getAdapterData(ResponseSignMainInfoVo responseSignMainInfoVo) {
        ArrayList arrayList = new ArrayList();
        LeftTitleToRightArrowVo leftTitleToRightArrowVo = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo.setTitle(true);
        leftTitleToRightArrowVo.setTitle(x.getString(R.string.title_rent_person_info));
        arrayList.add(leftTitleToRightArrowVo);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo2 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo2.setLeft(x.getString(R.string.title_user_name));
        leftTitleToRightArrowVo2.setRight(responseSignMainInfoVo.getUserName());
        arrayList.add(leftTitleToRightArrowVo2);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo3 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo3.setLeft(x.getString(R.string.title_phone_no));
        leftTitleToRightArrowVo3.setRight(x.getPhoneMask(responseSignMainInfoVo.getPhone()));
        arrayList.add(leftTitleToRightArrowVo3);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo4 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo4.setLeft(x.getString(R.string.title_card_type));
        leftTitleToRightArrowVo4.setRight(responseSignMainInfoVo.getIdCardType());
        arrayList.add(leftTitleToRightArrowVo4);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo5 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo5.setLeft(x.getString(R.string.title_id_card_no));
        leftTitleToRightArrowVo5.setRight(x.getIDNoMask(responseSignMainInfoVo.getIdCardNo()));
        arrayList.add(leftTitleToRightArrowVo5);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo6 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo6.setLeft(x.getString(R.string.title_nation));
        leftTitleToRightArrowVo6.setRight(responseSignMainInfoVo.getNation());
        arrayList.add(leftTitleToRightArrowVo6);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo7 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo7.setLeft(x.getString(R.string.title_work_unit));
        leftTitleToRightArrowVo7.setRight(responseSignMainInfoVo.getWorkspace());
        arrayList.add(leftTitleToRightArrowVo7);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo8 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo8.setLeft(x.getString(R.string.title_contract_address));
        leftTitleToRightArrowVo8.setRight(responseSignMainInfoVo.getContactAddress());
        arrayList.add(leftTitleToRightArrowVo8);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo9 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo9.setTitle(true);
        leftTitleToRightArrowVo9.setTitle(x.getString(R.string.title_urgent_contract));
        arrayList.add(leftTitleToRightArrowVo9);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo10 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo10.setLeft(x.getString(R.string.title_user_name));
        leftTitleToRightArrowVo10.setRight(responseSignMainInfoVo.getContactName());
        leftTitleToRightArrowVo10.setHint(x.getString(R.string.title_hint_input_urgent_contract_name));
        leftTitleToRightArrowVo10.setOnlyKey(3);
        leftTitleToRightArrowVo10.setEdit(true);
        leftTitleToRightArrowVo10.setShowArrow(true);
        leftTitleToRightArrowVo10.setRequired(true);
        arrayList.add(leftTitleToRightArrowVo10);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo11 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo11.setLeft(x.getString(R.string.title_phone_no));
        leftTitleToRightArrowVo11.setRight(responseSignMainInfoVo.getContactPhone());
        leftTitleToRightArrowVo11.setEdit(true);
        leftTitleToRightArrowVo11.setOnlyKey(4);
        leftTitleToRightArrowVo11.setShowArrow(true);
        leftTitleToRightArrowVo11.setRequired(true);
        leftTitleToRightArrowVo11.setMaxLength(11);
        leftTitleToRightArrowVo11.setHint(x.getString(R.string.title_hint_input_contract_name_phone));
        leftTitleToRightArrowVo11.setInputType(3);
        arrayList.add(leftTitleToRightArrowVo11);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo12 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo12.setLeft(x.getString(R.string.title_urgent_contract_relation));
        leftTitleToRightArrowVo12.setHint(x.getString(R.string.title_hint_input_urgent_contract_relation));
        leftTitleToRightArrowVo12.setOnlyKey(5);
        leftTitleToRightArrowVo12.setRight(responseSignMainInfoVo.getRelationship());
        leftTitleToRightArrowVo12.setEdit(true);
        leftTitleToRightArrowVo12.setRequired(true);
        leftTitleToRightArrowVo12.setShowArrow(true);
        arrayList.add(leftTitleToRightArrowVo12);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo13 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo13.setTitle(x.getString(R.string.title_together_live_person_info));
        leftTitleToRightArrowVo13.setTitle(true);
        arrayList.add(leftTitleToRightArrowVo13);
        LeftTitleToRightArrowVo leftTitleToRightArrowVo14 = new LeftTitleToRightArrowVo();
        leftTitleToRightArrowVo14.setType(8738);
        leftTitleToRightArrowVo14.setEdit(true);
        leftTitleToRightArrowVo14.setExtObj(a(responseSignMainInfoVo.getMaxRoommateNumber()));
        arrayList.add(leftTitleToRightArrowVo14);
        return arrayList;
    }

    public List<File> getIdCardFile(List<ContactDetailsVo.RoommatesBean> list) {
        ArrayList arrayList = new ArrayList();
        for (ContactDetailsVo.RoommatesBean roommatesBean : list) {
            if (roommatesBean != null) {
                String idCardBack = roommatesBean.getIdCardBack();
                String idCardFront = roommatesBean.getIdCardFront();
                if (x.isNotNull(idCardFront)) {
                    File file = new File(idCardFront);
                    if (file.exists()) {
                        arrayList.add(file);
                    }
                }
                if (x.isNotNull(idCardBack)) {
                    File file2 = new File(idCardBack);
                    if (file2.exists()) {
                        arrayList.add(file2);
                    }
                }
            }
        }
        return arrayList;
    }

    public CheckTogetherVo getSubmitMsg(List<LeftTitleToRightArrowVo> list) {
        CheckTogetherVo checkTogetherVo = new CheckTogetherVo();
        SignMainInfoVo signMainInfoVo = new SignMainInfoVo();
        for (LeftTitleToRightArrowVo leftTitleToRightArrowVo : list) {
            if (leftTitleToRightArrowVo != null) {
                int onlyKey = leftTitleToRightArrowVo.getOnlyKey();
                String right = leftTitleToRightArrowVo.getRight();
                if (onlyKey != 1) {
                    if (onlyKey != 2) {
                        if (onlyKey == 3) {
                            if (!x.isNotNull(right)) {
                                checkTogetherVo.setAddTogether(true);
                                checkTogetherVo.setTipMsg(x.getString(R.string.title_urgent_contract_name_is_empty));
                                return checkTogetherVo;
                            }
                            if (x.isNumeric(right) || right.length() == 1) {
                                checkTogetherVo.setAddTogether(true);
                                checkTogetherVo.setTipMsg(x.getString(R.string.title_urgent_contract_name_is_invalid));
                                return checkTogetherVo;
                            }
                            signMainInfoVo.setEmergencyName(right);
                        } else if (onlyKey == 4) {
                            if (!x.isNotNull(right)) {
                                checkTogetherVo.setAddTogether(true);
                                checkTogetherVo.setTipMsg(x.getString(R.string.title_urgent_person_phone_is_empty));
                                return checkTogetherVo;
                            }
                            String strTrimAll = x.trimAll(right);
                            if (!x.isMobile(strTrimAll)) {
                                checkTogetherVo.setAddTogether(true);
                                checkTogetherVo.setTipMsg(x.getString(R.string.title_urgent_person_phone_is_invalid));
                                return checkTogetherVo;
                            }
                            signMainInfoVo.setEmergencyPhone(strTrimAll);
                        } else if (onlyKey == 5) {
                            if (!x.isNotNull(right)) {
                                checkTogetherVo.setAddTogether(true);
                                checkTogetherVo.setTipMsg(x.getString(R.string.title_urgent_contract_relation_is_empty));
                                return checkTogetherVo;
                            }
                            signMainInfoVo.setEmergencyRelationship(right);
                        }
                    } else if (!x.isNotNull(right)) {
                        checkTogetherVo.setAddTogether(true);
                        checkTogetherVo.setTipMsg(x.getString(R.string.title_work_unit_is_not_empty));
                        return checkTogetherVo;
                    }
                } else if (!x.isNotNull(right)) {
                    checkTogetherVo.setAddTogether(true);
                    checkTogetherVo.setTipMsg(x.getString(R.string.title_work_address_is_not_empty));
                    return checkTogetherVo;
                }
                if (leftTitleToRightArrowVo.getType() == 8738) {
                    signMainInfoVo.setRoommates(b((List) leftTitleToRightArrowVo.getExtObj()));
                }
            }
        }
        checkTogetherVo.setSignMainInfoVo(signMainInfoVo);
        return checkTogetherVo;
    }

    public List<UpdateTogetherLiveBo.RoommatesBean> getUpdateTogetherLiveBoRoommatesBean(List<ContactDetailsVo.RoommatesBean> list) {
        ArrayList arrayList = new ArrayList();
        for (ContactDetailsVo.RoommatesBean roommatesBean : list) {
            if (roommatesBean != null && x.isNotNull(roommatesBean.getIdCardBackKey()) && x.isNotNull(roommatesBean.getIdCardFrontKey())) {
                UpdateTogetherLiveBo.RoommatesBean roommatesBean2 = new UpdateTogetherLiveBo.RoommatesBean();
                roommatesBean2.setIdCardBack(roommatesBean.getIdCardBackKey());
                roommatesBean2.setIdCardFront(roommatesBean.getIdCardFrontKey());
                roommatesBean2.setIdCardNo(x.trimAll(roommatesBean.getIdCardNo()));
                roommatesBean2.setPhone(x.trimAll(roommatesBean.getPhone()));
                roommatesBean2.setName(roommatesBean.getName());
                roommatesBean2.setIdCardType(roommatesBean.getCardType());
                arrayList.add(roommatesBean2);
            }
        }
        return arrayList;
    }

    public CheckTogetherVo isAddTogetherInfo(List<ContactDetailsVo.RoommatesBean> list) {
        CheckTogetherVo checkTogetherVo = new CheckTogetherVo();
        boolean z = false;
        z = false;
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            boolean z2 = false;
            for (int i2 = 0; i2 < size; i2++) {
                ContactDetailsVo.RoommatesBean roommatesBean = list.get(i2);
                if (roommatesBean != null) {
                    String name = roommatesBean.getName();
                    String phone = roommatesBean.getPhone();
                    String idCardNo = roommatesBean.getIdCardNo();
                    String idCardFront = roommatesBean.getIdCardFront();
                    String idCardBack = roommatesBean.getIdCardBack();
                    if (x.isNotNull(name) || x.isNotNull(phone) || x.isNotNull(idCardNo) || x.isNotNull(idCardFront) || x.isNotNull(idCardBack)) {
                        String strC = c(size, i2);
                        if (x.isNullStr(name)) {
                            checkTogetherVo.setTipMsg(strC + x.getString(R.string.title_person_name_is_empty));
                        } else if (x.isNullStr(phone)) {
                            checkTogetherVo.setTipMsg(strC + x.getString(R.string.tip_phone_is_empty));
                        } else if (x.isNotNull(phone) && !x.isMobile(phone)) {
                            checkTogetherVo.setTipMsg(strC + x.getString(R.string.tip_phone_is_failed));
                        } else if (x.isNullStr(idCardNo)) {
                            checkTogetherVo.setTipMsg(strC + x.getString(R.string.title_id_card_is_empty));
                        } else if (x.isNullStr(idCardFront)) {
                            checkTogetherVo.setTipMsg(strC + x.getString(R.string.title_id_card_face_is_empty));
                        } else if (x.isNullStr(idCardBack)) {
                            checkTogetherVo.setTipMsg(strC + x.getString(R.string.title_id_card_back_is_empty));
                        } else {
                            z2 = true;
                        }
                        z = true;
                        break;
                    }
                }
            }
            z = z2;
        }
        checkTogetherVo.setAddTogether(z);
        return checkTogetherVo;
    }

    public String renameFile(String str) {
        File file = new File(str);
        File file2 = new File(file.getParent(), System.currentTimeMillis() + ".jpg");
        return (file.exists() && file.renameTo(file2)) ? file2.getAbsolutePath() : str;
    }

    public void updateUploadIDKey(UploadResponseDto uploadResponseDto, LeftTitleToRightArrowVo leftTitleToRightArrowVo) {
        List list = (List) leftTitleToRightArrowVo.getExtObj();
        List<ResponseUploadImgVo> uploadSuccessList = uploadResponseDto.getUploadSuccessList();
        int size = uploadSuccessList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ResponseUploadImgVo responseUploadImgVo = uploadSuccessList.get(i2);
            if (responseUploadImgVo != null) {
                float f2 = i2 / 2.0f;
                int iFloor = (int) Math.floor(f2);
                if (f2 > iFloor) {
                    ((ContactDetailsVo.RoommatesBean) list.get(iFloor)).setIdCardBackKey(responseUploadImgVo.getKey());
                } else {
                    ((ContactDetailsVo.RoommatesBean) list.get(iFloor)).setIdCardFrontKey(responseUploadImgVo.getKey());
                }
            }
        }
    }
}
