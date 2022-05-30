package by.lexshi.flashlight

import android.content.Context
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager

/**
 * @author Lex Shi on 30.05.22
 */
class FlashLight() {

    fun flash(context: Context,boolean: Boolean) {
        var cameraManager: CameraManager =
            context.getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            var cameraId = cameraManager.cameraIdList[0]
            cameraManager.setTorchMode(cameraId,boolean)
        } catch (e: CameraAccessException) {
            e.printStackTrace()
        }
    }
}