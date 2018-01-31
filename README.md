To Implement this project use :

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

And

	dependencies {
	        compile 'com.github.Sameer-Jani-201:AndroidRuntimePermission:-SNAPSHOT'
	}


This is Android Runtime Permission on easy way and handle single as well as multiple permission very easily.
In this demo project created one AndroidRuntimePemrission.jar, which is kept in lib folder.
How to use this jar.This same demo use.You can allow runtime permission for Activity and Fragment both same way.
You will get 4 different callbacks as bellow :

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	//This below code you need to apply inside your override method
        if (permissionsRequestUtil != null) {
            permissionsRequestUtil.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    //Here you will get all the granted permssion name.
    @Override
    public void onPermissionGranted(String s) {

    }

    //Here you will get all the denied permission name.
    @Override
    public void onPermissionDenied(String s) {

    }

    //Here you will get all the blocked permissions.
    @Override
    public void onPermissionBlocked(String s) {

        //To open setting screen to allow permission manually using this below one line code.
        permissionsRequestUtil.showSettingDialog(MainActivity.this, s);
    }


    //This is main method where you write your actual further code.
    //When all the required permission granted that time this method will be involked.
    @Override
    public void onAllPermissionGranted() {
    }

Here Involked onPermissionGranted(String grantedPermissions) when you will get all the granted permission names.
Inside onPermissionDenied(String deniedPermissions) you will get all the denied permission names.
When some or any permission you have blocked by rational denied that means you have blocked this permission and you will not get permission dialog that time this method auto call and you can ask to user for allow manually and you can also navigate them to setting screen using inbuilt single line code :

	permissionsRequestUtil.showSettingDialog(MainActivity.this, s);


onAllPermissionGranted() this method call only and only if you have allowed all the permissions. So if when all the permissions are granted that time what you want to do that further task you can start from here.


Important Notes :

-> Add Given AndroidRuntimePermission.jar file in your lib folder.
-> Select Add As Library.
-> Add support-v13 dependancy in your build.gradle file.
-> Refer demo for how it's implement.
