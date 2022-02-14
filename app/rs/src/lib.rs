/**
 * @author Mrack
 * @date 2022/2/14
 */

use jni::sys::{jint, jstring, JavaVM, JNI_VERSION_1_6};
use jni::objects::JClass;
use jni::{JNIEnv};
use libc::c_void;

#[no_mangle]
unsafe fn JNI_OnLoad(jvm: JavaVM, _reserved: *mut c_void) -> jint {
    return JNI_VERSION_1_6;
}


#[no_mangle]
pub extern "system" fn Java_cn_mrack_rust_MainActivity_stringFromJNI(
    env: JNIEnv,
    _class: JClass,
) -> jstring {
    let hello = env
        .new_string("Hello Rust")
        .expect("Couldn't create java string!");
    hello.into_inner()
}
