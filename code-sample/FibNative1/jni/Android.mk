#C:\Users\didutta\workspace\FibNative>C:\DDDD\android-ndk-r10\ndk-build APP_ABI=all
LOCAL_PATH := $(call my-dir) 
include $(CLEAR_VARS)
APP_STL:=stlport_static 
LOCAL_LDLIBS += -llog
#LOCAL_LDLIBS += -lgnustl_shared

 
# Here we give our module name and source file(s)
#LOCAL_MODULE    := com_example_fibnative_FibLib
#LOCAL_SRC_FILES := com_example_fibnative_FibLib1.cpp

LOCAL_MODULE    := allLib
LOCAL_SRC_FILES := FileLib.cpp \
                   FibLib.cpp 

include $(BUILD_SHARED_LIBRARY)